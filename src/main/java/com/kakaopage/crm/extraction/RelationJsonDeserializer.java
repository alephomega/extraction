package com.kakaopage.crm.extraction;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationType;
import com.kakaopage.crm.extraction.ra.relations.RelationsPackage;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RelationJsonDeserializer implements JsonDeserializer<Relation> {
    private static final Map<String, Class<? extends Relation>> relationClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections(RelationsPackage.getName());
        Set<Class<? extends Relation>> classes = reflections.getSubTypesOf(Relation.class);

        for (Class<? extends Relation> clss : classes) {
            String identifier = getIdentifier(clss);
            if (identifier != null) {
                relationClasses.put(identifier, clss);
            }
        }
    }

    private static String getIdentifier(Class<? extends Relation> clss) {
        RelationType type = clss.getAnnotation(RelationType.class);
        if (type == null) {
            return null;
        }

        return type.value();
    }

    private static Class<? extends Relation> findClass(String name) {
        return relationClasses.get(name);
    }

    @Override
    public Relation deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        JsonObject relationJson = json.getAsJsonObject();
        String relationType = relationJson.get("@Type").getAsString();

        Class<? extends Relation> clss = findClass(relationType);
        if (clss == null) {
            throw new InvalidExpressionException(String.format("No relatioin with type: %s was found", relationType));
        }

        return context.deserialize(relationJson, clss);
    }
}
