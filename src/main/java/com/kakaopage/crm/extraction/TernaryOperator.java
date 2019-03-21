package com.kakaopage.crm.extraction;

import java.util.ArrayList;
import java.util.List;

public class TernaryOperator<F, S, T> implements Operator {
    private final F _1;
    private final S _2;
    private final T _3;

    public TernaryOperator(F _1, S _2, T _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    public F firstOperand() {
        return _1;
    }

    public S secondOperand() {
        return _2;
    }

    public T thirdOperand() {
        return _3;
    }

    @Override
    public List<?> getOperands() {
        List<Object> operands = new ArrayList<>();
        operands.add(_1);
        operands.add(_2);
        operands.add(_3);

        return operands;
    }
}