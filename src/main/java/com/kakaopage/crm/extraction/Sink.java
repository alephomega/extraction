package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.Relation;
import org.apache.commons.lang3.StringUtils;

public class Sink implements Expression {
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

    @Override
    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidExpressionException("name field must not be empty");
        }

        relation.validate();
    }
}