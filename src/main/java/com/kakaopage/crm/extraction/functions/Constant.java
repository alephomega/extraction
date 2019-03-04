package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("const")
public class Constant<T> implements Function {

    private final T value;

    public Constant(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
