package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("val")
public class Value implements Function {
    private final String dataset;
    private final String attribute;

    public Value(String dataset, String attribute) {
        this.dataset = dataset;
        this.attribute = attribute;
    }

    public String getDataset() {
        return dataset;
    }

    public String getAttribute() {
        return attribute;
    }
}