package com.kakaopage.crm.extraction;


import com.google.gson.*;
import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AssignmentJsonDeserializer implements JsonDeserializer<Assignment> {

    private static final Map<String, Class<? extends RelationalAlgebraOperator>> operationClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.kakaopage.crm.extraction.ra");
        Set<Class<? extends RelationalAlgebraOperator>> classes = reflections.getSubTypesOf(RelationalAlgebraOperator.class);

        for (Class<? extends RelationalAlgebraOperator> clss : classes) {
            String symbol = getSymbol(clss);
            if (symbol != null) {
                operationClasses.put(symbol, clss);
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

    private static Class<? extends Operator> findClass(String name) {
        return operationClasses.get(name);
    }

    @Override
    public Assignment deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject assignmentJson = json.getAsJsonObject();

        String variable = assignmentJson.get("variable").getAsString();
        JsonObject operationJson = assignmentJson.getAsJsonObject("operation");

        String symbol = operationJson.get("@Symbol").getAsString();
        Class<? extends Operator> clss = findClass(symbol);
        if (clss == null) {
            throw new RuntimeException();
        }

        RelationalAlgebraOperator operator = context.deserialize(operationJson, clss);
        return new Assignment(variable, operator);
    }
}
