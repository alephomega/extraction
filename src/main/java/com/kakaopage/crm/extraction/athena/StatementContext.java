package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;

class StatementContext {
    private NamingContext naming = new NamingContext();

    public void alias(String name, Function function) {
        naming.alias(name, function);
    }

    public NamingContext getNamingContext() {
        return naming;
    }
}