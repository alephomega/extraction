package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

public class Cardinality implements ArrayFunction {
    private final Function array;

    public Cardinality(Function array) {
        this.array = array;
    }

    public Function getArray() {
        return array;
    }
}
