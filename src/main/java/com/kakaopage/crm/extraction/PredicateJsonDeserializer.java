package com.kakaopage.crm.extraction;

import com.google.gson.*;
import com.kakaopage.crm.extraction.predicates.PredicatesPackage;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class PredicateJsonDeserializer implements JsonDeserializer<Predicate> {

    private static final Map<String, Class<? extends Predicate>> predicateClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections(PredicatesPackage.getName());
        Set<Class<? extends Predicate>> classes = reflections.getSubTypesOf(Predicate.class);

        for (Class<? extends Predicate> clss : classes) {
            String operator = getSymbol(clss);
            if (operator != null) {
                predicateClasses.put(operator, clss);
            }
        }
    }

    private static String getSymbol(Class<? extends Operator> clss) {
        Symbol symbol = clss.getAnnotation(Symbol.class);
        if (symbol == null) {
            return null;
        }

        return symbol.value();
    }

    private static Class<? extends Predicate> findClass(String name) {
        return predicateClasses.get(name);
    }

    @Override
    public Predicate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject predicateJson = json.getAsJsonObject();
        String symbol = predicateJson.get("@Symbol").getAsString();
        Class<? extends Predicate> clss = findClass(symbol);

        return context.deserialize(predicateJson, clss);
    }
}
