package com.kakaopage.crm.extraction;

import com.google.gson.*;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionJsonDeserializer implements JsonDeserializer<Function> {

    private static final Map<String, Class<? extends Function>> functionClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.kakaopage.global.crm.extraction.ra");
        Set<Class<? extends Function>> classes = reflections.getSubTypesOf(Function.class);

        for (Class<? extends Function> clss : classes) {
            String operator = getOperator(clss);
            if (operator != null) {
                functionClasses.put(operator, clss);
            }
        }
    }

    private static String getOperator(Class<? extends Function> clss) {
        Operator operator = clss.getAnnotation(Operator.class);
        if (operator == null) {
            return null;
        }

        return operator.value();
    }

    private static Class<? extends Function> findClass(String name) {
        return functionClasses.get(name);
    }

    @Override
    public Function deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject functionJson = json.getAsJsonObject();
        String operator = functionJson.get("operator").getAsString();

        Class<? extends Function> clss = findClass(operator);
        return context.deserialize(functionJson.get("operands"), clss);
    }
}
