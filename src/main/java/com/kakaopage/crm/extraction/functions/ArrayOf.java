package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

import java.util.List;

public class ArrayOf implements Function {
    private final List<Function> elements;

    public ArrayOf(List<Function> elements) {
        this.elements = elements;
    }

    public List<Function> getElements() {
        return elements;
    }
}
