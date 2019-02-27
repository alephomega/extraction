package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;

class QueryContext {

    private Schema schema;
    private NamingContext naming = new NamingContext();

    public Schema getSchema() {
        return schema;
    }

    public void alias(String name, Function function) {
        naming.alias(name, function);
    }

    public NamingContext getNamingContext() {
        return naming;
    }
}