package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.*;

@Symbol("#")
public class Ignorable extends BinaryOperator<Predicate, Boolean> implements Predicate {

    public Ignorable(Predicate predicate, boolean ignore) {
        super(predicate, ignore);
    }

    public Predicate getPredicate() {
        return firstOperand();
    }

    public boolean isIgnore() {
        return secondOperand();
    }

    @Override
    public String toPushDownExpression() {
        return isIgnore() ? "1 = 1" : getPredicate().toPushDownExpression();
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (!isIgnore()) {
            getPredicate().validate();
        }
    }
}
