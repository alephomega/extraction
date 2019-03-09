package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("val")
public class Value implements Function {
    private final String dataSet;
    private final String attribute;

    public Value(String dataSet, String attribute) {
        this.dataSet = dataSet;
        this.attribute = attribute;
    }

    public String getDataSet() {
        return dataSet;
    }

    public String getAttribute() {
        return attribute;
    }
}