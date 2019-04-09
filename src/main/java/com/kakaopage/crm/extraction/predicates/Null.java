package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.*;
import com.kakaopage.crm.extraction.functions.Value;

@Symbol("∅")
public class Null extends UnaryOperator<Value> implements Predicate {

    public Null(Value value) {
        super(value);
    }

    public Value getValue() {
        return getSingleOperand();
    }

    @Override
    public String toPushDownExpression() {
        return String.format("%s is null", getValue().toPushDownExpression());
    }

    @Override
    public void validate() throws InvalidExpressionException {
        Value value = getValue();
        if (value == null) {
            throw new InvalidExpressionException("value argument must not be null");
        }

        value.validate();
    }
}
