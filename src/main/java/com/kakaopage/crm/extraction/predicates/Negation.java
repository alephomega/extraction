package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.UnaryOperator;

@Symbol("¬")
public class Negation extends UnaryOperator<Predicate> implements LogicalOperator {
    public Negation(Predicate predicate) {
        super(predicate);
    }

    public Predicate getPredicate() {
        return getSingleOperand();
    }

    @Override
    public String toPushDownExpression() {
        return String.format("not (%s)", getPredicate().toPushDownExpression());
    }
}
