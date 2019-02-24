package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Operator;
import com.kakaopage.crm.extraction.Predicate;

import java.util.List;

@Operator("∨")
class Disjunction implements LogicalOperation {
    private final List<Predicate> predicates;

    Disjunction(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }
}
