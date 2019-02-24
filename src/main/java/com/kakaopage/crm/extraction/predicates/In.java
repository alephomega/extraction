package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Operator;
import com.kakaopage.crm.extraction.functions.Constant;

import java.util.List;

@Operator("∈")
class In<T> extends ComparativeOperation {

    In(Function value, Constant<List<T>> elements) {
        super(value, elements);
    }

    public List<T> getElements() {
        return (List<T>) ((Constant) getF2()).getValue();
    }
}