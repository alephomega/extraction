package com.kakaopage.global.crm.extraction;

import java.util.List;

public class Filter implements Operation {
    private final List<Predicate> predicates;

    public Filter(List<Predicate> predicates) {
        this.predicates = predicates;
    }
}