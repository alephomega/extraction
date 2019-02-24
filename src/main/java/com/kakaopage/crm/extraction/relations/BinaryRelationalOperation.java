package com.kakaopage.crm.extraction.relations;

public class BinaryRelationalOperation implements RelationalOperation {
    private final Relation first;
    private final Relation second;

    public BinaryRelationalOperation(Relation first, Relation second) {
        this.first = first;
        this.second = second;
    }

    public Relation getFirst() {
        return first;
    }

    public Relation getSecond() {
        return second;
    }

    @Override
    public Relation[] inputs() {
        return new Relation[] { first, second };
    }
}
