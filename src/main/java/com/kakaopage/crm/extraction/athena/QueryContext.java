package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;

import java.util.Map;

public class QueryContext {
    private Schema schema;
    private Map<String, Function> naming;

    public Function getFunction(String alias) {
        return naming.get(alias);
    }
}
