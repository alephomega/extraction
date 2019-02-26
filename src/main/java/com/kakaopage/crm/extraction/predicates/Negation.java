package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.UnaryOperator;

@Symbol("¬")
class Negation extends UnaryOperator<Predicate> implements LogicalOperator {
    Negation(Predicate predicate) {
        super(predicate);
    }

    public Predicate getPredicate() {
        return getSingleOperand();
    }
}
