package com.kakaopage.global.crm.extraction.description;

import java.util.Map;

public class Transformation {
    private final String operator;
    private final Object[] inputs;
    private final Map<String, ?> params;

    public Transformation(String operator, Object[] inputs, Map<String, ?> params) {
        this.operator = operator;
        this.inputs = inputs;
        this.params = params;
    }

    public String getOperator() {
        return operator;
    }

    public Object[] getInputs() {
        return inputs;
    }

    public Map<String, ?> getParams() {
        return params;
    }
}
