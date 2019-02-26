package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.functions.Constant;

import java.util.List;

@Symbol("∈")
class In<T> extends ComparativeOperator {

    In(Function value, Constant<List<T>> elements) {
        super(value, elements);
    }

    public List<T> getElements() {
        Constant<List<T>> _2 = (Constant<List<T>>) getSecondOperand();
        return _2.getValue();
    }
}