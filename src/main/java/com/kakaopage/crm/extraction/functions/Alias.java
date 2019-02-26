package com.kakaopage.crm.extraction.functions;


import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("as")
public class Alias implements Function {
    private final Function function;
    private final String alias;

    public Alias(Function function, String alias) {
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
