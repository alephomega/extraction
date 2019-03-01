package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;

public class SelectExpression {
    private Function function;
    private String name;

    public SelectExpression(Function function, String name) {
        this.function = function;
        this.name = name;
    }

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

    @Override
    public String toString() {
        if (name == null) {
            return function.toString();
        }

        return String.format("%s as %s", function, name);
    }
}
