package com.kakaopage.crm.extraction;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kakaopage.crm.extraction.functions.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FunctionJsonDeserializer implements JsonDeserializer<Function> {

    private static final Map<String, Class<? extends Function>> functionClasses = new HashMap<>();

    static {
        List<Class> classes = PackageScanner.getSubTypesOf(FunctionsPackage.getName(), Function.class);
        for (Class<? extends Function> functionClass : classes) {
            String identifier = getIdentifier(functionClass);
            if (identifier != null) {
                functionClasses.put(identifier, functionClass);
            }
        }
    }

    private static String getIdentifier(Class<? extends Function> clss) {
        FuncIdentifier identifier = clss.getAnnotation(FuncIdentifier.class);
        if (identifier == null) {
            return null;
        }

        return identifier.value();
    }

    private static Class<? extends Function> findClass(String name) {
        return functionClasses.get(name);
    }

    @Override
    public Function deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
        JsonObject functionJson = json.getAsJsonObject();
        String identifier = functionJson.get("@FuncIdentifier").getAsString();

        Class<? extends Function> clss = findClass(identifier);
        if (clss == null) {
            throw new InvalidExpressionException(String.format("No function with identifier: %s was found", identifier));
        }

        return context.deserialize(functionJson, clss);
    }
}