package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.Relation;

public class Sink implements Expression {
    private final Sampling sampling;
    private final Partitioning partitioning;
    private final Relation relation;

    public Sink(Partitioning partitioning, Relation relation) {
        this(null, partitioning, relation);
    }

    public Sink(Sampling sampling, Partitioning partitioning, Relation relation) {
        this.sampling = sampling;
        this.partitioning = partitioning;
        this.relation = relation;
    }

    public Relation getRelation() {
        return relation;
    }

    public boolean needSampling() {
        return sampling != null && sampling.getSize() > 0;
    }

    public Sampling getSampling() {
        return sampling;
    }

    public Partitioning getPartitioning() {
        return partitioning;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        relation.validate();
    }
}