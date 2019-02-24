package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Operator;
import com.kakaopage.crm.extraction.Predicate;

import java.util.List;

@Operator("∧")
class Conjunction implements LogicalOperation {

    private final List<Predicate> predicates;

    Conjunction(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }
}
