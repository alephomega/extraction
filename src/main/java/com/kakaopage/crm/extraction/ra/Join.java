package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("⨝")
public class Join extends BinaryRelationalAlgebraOperator {
    private final Predicate condition;

    public Join(Predicate condition, Relation first, Relation second) {
        super(first, second);
        this.condition = condition;
    }

    public Predicate getCondition() {
        return condition;
    }
}