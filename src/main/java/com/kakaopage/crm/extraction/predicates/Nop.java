package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.UnaryOperator;

@Symbol("_")
public class Nop extends UnaryOperator<Predicate> implements Predicate {

    public Nop(Predicate predicate) {
        super(predicate);
    }

    public Predicate getPredicate() {
        return getSingleOperand();
    }

    @Override
    public String toPushDownExpression() {
        return getPredicate().toPushDownExpression();
    }

    @Override
    public void validate() throws InvalidExpressionException {
        getPredicate().validate();
    }
}
