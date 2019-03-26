package com.kakaopage.crm.extraction;

import java.util.Collections;
import java.util.List;

public abstract class UnaryOperator<T> implements Operator {
    private final T _1;

    public UnaryOperator(T _1) {
        this._1 = _1;
    }

    public T getSingleOperand() {
        return _1;
    }

    public List<?> getOperands() {
        return Collections.singletonList(_1);
    }
}
