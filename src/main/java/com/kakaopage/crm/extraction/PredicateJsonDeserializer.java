package com.kakaopage.crm.extraction;

import com.google.gson.*;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PredicateJsonDeserializer implements JsonDeserializer<Predicate> {

    private static final Map<String, Class<? extends Predicate>> predicateClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.kakaopage.global.crm.extraction.ra");
        Set<Class<? extends Predicate>> classes = reflections.getSubTypesOf(Predicate.class);

        for (Class<? extends Predicate> clss : classes) {
            String operator = getOperator(clss);
            if (operator != null) {
                predicateClasses.put(operator, clss);
            }
        }
    }

    private static String getOperator(Class<? extends Operation> clss) {
        Operator operator = clss.getAnnotation(Operator.class);
        if (operator == null) {
            return null;
        }

        return operator.value();
    }

    private static Class<? extends Predicate> findClass(String name) {
        return predicateClasses.get(name);
    }

    @Override
    public Predicate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject predicateJson = json.getAsJsonObject();
        String operator = predicateJson.get("operator").getAsString();
        Class<? extends Predicate> clss = findClass(operator);

        return context.deserialize(predicateJson.get("operands"), clss);
    }
}
