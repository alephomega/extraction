package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Value;

import java.util.HashMap;
import java.util.Map;

public class NamingContext {
    private Map<String, Function> naming = new HashMap<>();

    public Function get(String alias) {
        return naming.get(alias);
    }

    void alias(String name, Function function) {
        if (function instanceof Value) {
            Value value = (Value) function;
            if (value.getAttribute().equals(name)) {
                return;
            }
        }

        naming.put(name, function);
    }
}
