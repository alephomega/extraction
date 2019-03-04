package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

abstract class AggregateFunction implements Function {
    private final Function function;

    AggregateFunction(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
