package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Description;
import com.kakaopage.crm.extraction.Function;

public class Aggregation implements Description {
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