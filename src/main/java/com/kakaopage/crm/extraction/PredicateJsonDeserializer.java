package com.kakaopage.crm.extraction;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kakaopage.crm.extraction.predicates.PredicatesPackage;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PredicateJsonDeserializer implements JsonDeserializer<Predicate> {

    private static final Map<String, Class<? extends Predicate>> predicateClasses = new HashMap<>();

    static {
        List<Class> classes = PackageScanner.getSubTypesOf(PredicatesPackage.getName(), Predicate.class);
        for (Class<? extends Predicate> predicateClass : classes) {
            String operator = getSymbol(predicateClass);
            if (operator != null) {
                predicateClasses.put(operator, predicateClass);
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
    public Predicate deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        JsonObject predicateJson = json.getAsJsonObject();
        String symbol = predicateJson.get("@Symbol").getAsString();
        Class<? extends Predicate> clss = findClass(symbol);
        if (clss == null) {
            throw new InvalidExpressionException(String.format("No predicate with symbol: %s was found", symbol));
        }

        return context.deserialize(predicateJson, clss);
    }
}
