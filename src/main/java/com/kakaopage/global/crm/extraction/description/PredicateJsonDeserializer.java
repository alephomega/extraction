package com.kakaopage.global.crm.extraction.description;

import com.google.gson.*;
import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.FormulaFactory;
import com.kakaopage.global.crm.extraction.Predicate;
import com.kakaopage.global.crm.extraction.PredicateFactory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

class PredicateJsonDeserializer implements JsonDeserializer<Predicate> {

    @Override
    public Predicate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject description = json.getAsJsonObject();

        String operator = description.get("@Operator").getAsString();
        JsonObject params = description.getAsJsonObject("params");

        return PredicateFactory.predicateOf(operator, deserializeParams(params, context));
    }

    private Map<String, ?> deserializeParams(JsonObject json, JsonDeserializationContext context) {
        Map<String, Object> params = new HashMap<>();

        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            if (isFormulaJsonObject(value)) {
                params.put(key, deserializeFormula(value.getAsJsonObject(), context));
            } else {
                params.put(key, context.deserialize(value, Object.class));
            }
        }

        return params;
    }

    private Formula deserializeFormula(JsonElement json, JsonDeserializationContext context) throws JsonParseException {
        JsonObject description = json.getAsJsonObject();

        String symbol = description.get("@Symbol").getAsString();
        JsonObject params = description.getAsJsonObject("params");

        return FormulaFactory.formulaOf(symbol, deserializeParams(params, context));
    }


    private static boolean isFormulaJsonObject(JsonElement json) {
        if (json.isJsonObject()) {
            if (json.getAsJsonObject().get("@Symbol") != null) {
                return true;
            }
        }

        return false;
    }
}
