package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.Symbol;

import java.util.ArrayList;
import java.util.List;

@Symbol("⊤")
public class True implements LogicalOperator {

    @Override
    public List<?> getOperands() {
        return new ArrayList<>(0);
    }

    @Override
    public void validate() throws InvalidExpressionException {

    }

    @Override
    public String toPushDownExpression() {
        return "1 = 1";
    }
}
