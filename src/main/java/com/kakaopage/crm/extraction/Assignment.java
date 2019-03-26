package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;
import org.apache.commons.lang3.StringUtils;

public class Assignment implements Expression {

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

    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(variable)) {
            throw new InvalidExpressionException("variable field must not be empty");
        }

        operation.validate();
    }
}
