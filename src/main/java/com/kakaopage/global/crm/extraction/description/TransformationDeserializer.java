package com.kakaopage.global.crm.extraction.description;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class TransformationDeserializer implements JsonDeserializer<Transformation> {

    @Override
    public Transformation deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        return deserializeTransformation(json, context);
    }

    private Transformation deserializeTransformation(JsonElement json, JsonDeserializationContext context) {
        JsonObject jsonObject = json.getAsJsonObject();

        String operator = jsonObject.get("@Operator").getAsString();
        Map<String, ?> params = context.deserialize(jsonObject.getAsJsonObject("params"), new TypeToken<Map<String, ?>>(){}.getType());

        JsonArray inputsJson = jsonObject.getAsJsonArray("inputs");

        Object[] inputs = new Object[inputsJson.size()];
        for (int i = 0; i < inputsJson.size(); i++) {
            JsonElement inputJson = inputsJson.get(i);

            if (inputJson.isJsonObject()) {
                inputs[i] = deserializeTransformation(inputJson, context);
            } else {
                inputs[i] = inputJson.getAsString();
            }
        }

        return new Transformation(operator, inputs, params);
    }
}
