package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

public class MaxElement implements ArrayFunction {
    private final Function array;

    public MaxElement(Function array) {
        this.array = array;
    }

    public Function getArray() {
        return array;
    }
}
