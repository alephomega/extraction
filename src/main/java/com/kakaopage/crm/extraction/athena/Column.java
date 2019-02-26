package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;

public class Column {
    private Function function;
    private String alias;

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
