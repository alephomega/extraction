package com.kakaopage.crm.extraction;


import com.google.gson.*;
import com.kakaopage.crm.extraction.relations.RelationalOperation;
import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AssignmentJsonDeserializer implements JsonDeserializer<Assignment> {

    private static final Map<String, Class<? extends RelationalOperation>> operationClasses = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.kakaopage.global.crm.extraction.ra");
        Set<Class<? extends RelationalOperation>> classes = reflections.getSubTypesOf(RelationalOperation.class);

        for (Class<? extends RelationalOperation> clss : classes) {
            String operator = getOperator(clss);
            if (operator != null) {
                operationClasses.put(operator, clss);
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

    private static Class<? extends Operation> findClass(String name) {
        return operationClasses.get(name);
    }

    @Override
    public Assignment deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject assignmentJson = json.getAsJsonObject();

        String variable = assignmentJson.get("variable").getAsString();
        JsonObject operationJson = assignmentJson.getAsJsonObject("operation");

        String operator = operationJson.get("operator").getAsString();
        Class<? extends Operation> clss = findClass(operator);
        if (clss == null) {
            throw new RuntimeException();
        }

        RelationalOperation operation = context.deserialize(operationJson.get("operands"), clss);
        return new Assignment(variable, operation);
    }

    private Operation deserializeOperation(Map.Entry<String, JsonElement> description, JsonDeserializationContext context) {
        String operator = description.getKey();
        Class<? extends Operation> clss = findClass(operator);
        if (clss == null) {
            throw new RuntimeException();
        }

        return context.deserialize(description.getValue(), clss);
    }
}
