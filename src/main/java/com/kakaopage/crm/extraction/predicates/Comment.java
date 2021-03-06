package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.UnaryOperator;

@Symbol("#")
public class Comment extends UnaryOperator<Predicate> implements Predicate {

    public Comment(Predicate predicate) {
        super(predicate);
    }

    public Predicate getPredicate() {
        return getSingleOperand();
    }

    @Override
    public String toPushDownExpression() {
        return "1 = 1";
    }

    @Override
    public void validate() throws InvalidExpressionException {

    }
}
