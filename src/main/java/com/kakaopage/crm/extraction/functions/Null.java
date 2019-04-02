package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.PushDown;

@FuncIdentifier("is_null")
public class Null implements Function, PushDown {
    private final Value value;

    public Null(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toPushDownExpression() {
        return String.format("%s is null", value.toPushDownExpression());
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (value == null) {
            throw new InvalidExpressionException("value argument must not be null");
        }

        value.validate();
    }
}
