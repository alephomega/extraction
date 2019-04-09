package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.Relation;

public class Sink implements Expression {
    private final Partitioning partitioning;
    private final Relation relation;

    public Sink(Partitioning partitioning, Relation relation) {
        this.partitioning = partitioning;
        this.relation = relation;
    }

    public Relation getRelation() {
        return relation;
    }

    public Partitioning getPartitioning() {
        return partitioning;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        relation.validate();
    }
}