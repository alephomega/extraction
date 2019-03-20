package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.PushDown;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.functions.Constant;

import java.util.List;

@Symbol("∈")
public class IsIn<T> extends ComparativeOperator {

    public IsIn(Function value, Constant<List<T>> elements) {
        super(value, elements);
    }

    public Function getValue() {
        return firstOperand();
    }

    public List<T> getElements() {
        Constant<List<T>> _2 = (Constant<List<T>>) secondOperand();
        return _2.getValue();
    }

    @Override
    public String toPushDownExpression() {
        PushDown _1 = (PushDown) firstOperand();
        PushDown _2 = (PushDown) secondOperand();

        return String.format("%s in %s", _1.toPushDownExpression(), _2.toPushDownExpression());
    }
}