package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

abstract class ArrayFunction implements Function {

    private final Function array;

    ArrayFunction(Function array) {
        this.array = array;
    }

    public Function getArray() {
        return array;
    }
}
