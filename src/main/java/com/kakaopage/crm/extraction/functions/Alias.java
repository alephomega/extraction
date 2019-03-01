package com.kakaopage.crm.extraction.functions;


import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("as")
public class Alias implements Function {
    private final Function function;
    private final String name;

    public Alias(Function function, String name) {
        this.function = function;
        this.name = name;
    }

    public Function getFunction() {
        return function;
    }

    public String getName() {
        return name;
    }
}
