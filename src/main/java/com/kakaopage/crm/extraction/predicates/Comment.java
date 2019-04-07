package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.*;

@Symbol("#")
public class Comment extends BinaryOperator<Predicate, Boolean> implements Predicate {

    public Comment(Predicate predicate, boolean enabled) {
        super(predicate, enabled);
    }

    public Predicate getPredicate() {
        return firstOperand();
    }

    public boolean isEnabled() {
        return secondOperand();
    }

    @Override
    public String toPushDownExpression() {
        return isEnabled() ? "1 = 1" : getPredicate().toPushDownExpression();
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (!isEnabled()) {
            getPredicate().validate();
        }
    }
}
