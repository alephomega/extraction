package com.kakaopage.crm.extraction;

import com.google.gson.*;
import com.kakaopage.crm.extraction.functions.FunctionsPackage;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class FunctionJsonDeserializer implements JsonDeserializer<Function> {

    private static final Map<String, Class<? extends Function>> functionClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections(FunctionsPackage.getName());
        Set<Class<? extends Function>> classes = reflections.getSubTypesOf(Function.class);

        for (Class<? extends Function> clss : classes) {
            String identifier = getIdentifier(clss);
            if (identifier != null) {
                functionClasses.put(identifier, clss);
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
    public Function deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject functionJson = json.getAsJsonObject();
        String identifier = functionJson.get("@FuncIdentifier").getAsString();

        Class<? extends Function> clss = findClass(identifier);
        return context.deserialize(functionJson, clss);
    }
}