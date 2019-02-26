package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.BinaryOperator;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;

public abstract class ComparativeOperator extends BinaryOperator<Function, Function> implements Predicate {
    ComparativeOperator(Function _1, Function _2) {
        super(_1, _2);
    }
}
