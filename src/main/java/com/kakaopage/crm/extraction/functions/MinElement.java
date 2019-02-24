package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

public class MinElement implements ArrayFunction {
    private final Function array;

    public MinElement(Function array) {
        this.array = array;
    }

    public Function getArray() {
        return array;
    }
}
