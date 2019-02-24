package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.relations.Relation;

class Sink implements Step {
    private final String name;
    private final Relation relation;

    Sink(String name, Relation relation) {
        this.name = name;
        this.relation = relation;
    }
}
