package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.Relation;

public class Sink implements Step {
    private final String name;
    private final Partitioning partitioning;
    private final Relation relation;

    public Sink(String name, Partitioning partitioning, Relation relation) {
        this.name = name;
        this.partitioning = partitioning;
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public Relation getRelation() {
        return relation;
    }

    public Partitioning getPartitioning() {
        return partitioning;
    }
}