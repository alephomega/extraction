package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.PushDown;
import com.kakaopage.crm.extraction.TernaryOperator;

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
}
