package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Expression;
import com.kakaopage.crm.extraction.Function;

public class Aggregation implements Expression {
    private final Function function;
    private final String alias;


    public Aggregation(Function function, String alias) {
        this.function = function;
        this.alias = alias;
    }

    public Function getFunction() {
        return function;
    }

    public String getAlias() {
        return alias;
    }
}