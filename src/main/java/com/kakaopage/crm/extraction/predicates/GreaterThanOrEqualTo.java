package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.PushDown;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("≥")
public class GreaterThanOrEqualTo extends ComparativeOperator {

    public GreaterThanOrEqualTo(Function _1, Function _2) {
        super(_1, _2);
    }

    @Override
    public String toPushDownExpression() {
        PushDown _1 = (PushDown) firstOperand();
        PushDown _2 = (PushDown) secondOperand();

        return String.format("%s >= %s", _1.toPushDownExpression(), _2.toPushDownExpression());
    }

    @Override
    public void validate() throws InvalidExpressionException {
        Function _1 = firstOperand();
        if (_1 == null) {
            throw new InvalidExpressionException("_1 argument must not be null");
        }

        Function _2 = secondOperand();
        if (_2 == null) {
            throw new InvalidExpressionException("_2 argument must not be null");
        }

        _1.validate();
        _2.validate();
    }
}
