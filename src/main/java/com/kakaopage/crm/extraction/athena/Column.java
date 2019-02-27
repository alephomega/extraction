package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;

public class Column {
    private Function function;
    private String name;

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toQueryString() {
        if (name == null) {
            return function.toString();
        }

        return String.format("%s as %s", function, name);
    }
}
