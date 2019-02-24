package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

import java.util.List;

@Operator("π")
public class Projection extends UnaryRelationalOperation {
    private final List<String> columns;

    public Projection(List<String> columns, Relation relation) {
        super(relation);
        this.columns = columns;
    }

    public List<String> getColumns() {
        return columns;
    }
}
