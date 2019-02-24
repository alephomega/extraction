package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.relations.RelationalOperation;

class Assignment implements Step {
    private final String variable;
    private final RelationalOperation operation;

    Assignment(String variable, RelationalOperation operation) {
        this.variable = variable;
        this.operation = operation;
    }

    public String getVariable() {
        return variable;
    }

    public RelationalOperation getOperation() {
        return operation;
    }
}
