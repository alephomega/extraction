package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

public class SumOfElements implements ArrayFunction {
    private final Function array;

    public SumOfElements(Function array) {
        this.array = array;
    }

    public Function getArray() {
        return array;
    }
}
