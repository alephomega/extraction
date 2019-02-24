package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;
import com.kakaopage.crm.extraction.Predicate;

@Operator("σ")
public class Selection extends UnaryRelationalOperation {
    private final Predicate condition;

    Selection(Predicate condition, Relation relation) {
        super(relation);
        this.condition = condition;
    }

    public Predicate getCondition() {
        return condition;
    }
}
