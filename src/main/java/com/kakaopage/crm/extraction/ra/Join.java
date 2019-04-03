package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("⨝")
public class Join extends BinaryRelationalAlgebraOperator {
    private final Predicate condition;
    private final boolean duplicatesAllowed;

    public Join(Predicate condition, boolean duplicatesAllowed, Relation first, Relation second) {
        super(first, second);
        this.condition = condition;
        this.duplicatesAllowed = duplicatesAllowed;
    }

    public Predicate getCondition() {
        return condition;
    }

    public boolean isDuplicatesAllowed() {
        return duplicatesAllowed;
    }
}