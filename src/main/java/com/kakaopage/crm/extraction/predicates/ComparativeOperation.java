package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;

public abstract class ComparativeOperation implements Predicate {
    private final Function f1;
    private final Function f2;

    protected ComparativeOperation(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public Function getF1() {
        return f1;
    }

    public Function getF2() {
        return f2;
    }
}
