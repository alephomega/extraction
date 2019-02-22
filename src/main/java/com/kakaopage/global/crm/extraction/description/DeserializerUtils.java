package com.kakaopage.global.crm.extraction.description;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class DeserializerUtils {
    public static Map<String, Object> obj2map(JsonObject json, JsonDeserializationContext context) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (json != null) {
            for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
                map.put(entry.getKey(), context.deserialize(entry.getValue(), Object.class));
            }
        }

        return map;
    }
}
