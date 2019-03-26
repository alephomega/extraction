package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.*;

public class Between extends TernaryOperator<Function, Function, Function> implements Predicate {

    public Between(Function _1, Function _2, Function _3) {
        super(_1, _2, _3);
    }

    @Override
    public String toPushDownExpression() {
        PushDown _1 = (PushDown) firstOperand();
        PushDown _2 = (PushDown) secondOperand();
        PushDown _3 = (PushDown) thirdOperand();

        return String.format("%s between (%s, %s)", _1.toPushDownExpression(), _2.toPushDownExpression(), _3.toPushDownExpression());
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

        Function _3 = thirdOperand();
        if (_3 == null) {
            throw new InvalidExpressionException("_3 argument must not be null");
        }


        _1.validate();
        _2.validate();
        _3.validate();
    }
}
