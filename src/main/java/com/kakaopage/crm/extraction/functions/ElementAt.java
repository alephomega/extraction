package com.kakaopage.crm.extraction.functions;

public class ElementAt implements ArrayFunction {
    private final int index;

    public ElementAt(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
