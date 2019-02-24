package com.kakaopage.crm.extraction.relations;

public class UnaryRelationalOperation implements RelationalOperation {
    private final Relation relation;

    public UnaryRelationalOperation(Relation relation) {
        this.relation = relation;
    }

    @Override
    public Relation[] inputs() {
        return new Relation[] { relation };
    }
}
