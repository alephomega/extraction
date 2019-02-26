package com.kakaopage.crm.extraction;

import java.util.ArrayList;
import java.util.List;

public class BinaryOperator<F, S> implements Operator {
    private final F _1;
    private final S _2;

    public BinaryOperator(F _1, S _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public F getFirstOperand() {
        return _1;
    }

    public S getSecondOperand() {
        return _2;
    }

    @Override
    public List<?> getOperands() {
        List<Object> operands = new ArrayList<>();
        operands.add(_1);
        operands.add(_2);

        return operands;
    }
}
