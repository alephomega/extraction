package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.relations.RelationalAlgebraOperator;

public class Assignment implements Step {
    private final String variable;
    private final RelationalAlgebraOperator operation;

    Assignment(String variable, RelationalAlgebraOperator operation) {
        this.variable = variable;
        this.operation = operation;
    }

    public String getVariable() {
        return variable;
    }

    public RelationalAlgebraOperator getOperation() {
        return operation;
    }
}
