package com.kakaopage.crm.extraction.ra;

public class Relation {
    private final String name;
    private final Schema schema;

    public Relation(String name, Schema schema) {
        this.name = name;
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public Schema getSchema() {
        return schema;
    }
}
