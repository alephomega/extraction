package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.PushDown;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("=")
public class Equals extends ComparativeOperator {

    public Equals(Function _1, Function _2) {
        super(_1, _2);
    }

    @Override
    public String toPushDownExpression() {
        PushDown _1 = (PushDown) firstOperand();
        PushDown _2 = (PushDown) secondOperand();

        return String.format("%s = %s", _1.toPushDownExpression(), _2.toPushDownExpression());
    }
}
