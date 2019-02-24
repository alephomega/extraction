package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Operator;
import com.kakaopage.crm.extraction.Predicate;

@Operator("¬")
class Negation implements LogicalOperation {
    private final Predicate predicate;

    Negation(Predicate predicate) {
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
