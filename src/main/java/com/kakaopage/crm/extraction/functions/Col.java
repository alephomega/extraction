package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Operator;

@Operator("col")
public class Col implements Function {
    private final String name;

    Col(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}