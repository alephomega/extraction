package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.PushDown;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("<")
public class LessThan extends ComparativeOperator {

    public LessThan(Function f1, Function f2) {
        super(f1, f2);
    }

    @Override
    public String toPushDownExpression() {
        PushDown _1 = (PushDown) firstOperand();
        PushDown _2 = (PushDown) secondOperand();

        return String.format("%s < %s", _1.toPushDownExpression(), _2.toPushDownExpression());
    }
}
