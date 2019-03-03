package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.Relation;

public class Sink implements Step {
    private final String name;
    private final Relation relation;

    public Sink(String name, Relation relation) {
        this.name = name;
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public Relation getRelation() {
        return relation;
    }
}
