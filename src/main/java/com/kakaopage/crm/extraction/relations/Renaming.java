package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

import java.util.List;

@Operator("ρ")
public class Renaming extends UnaryRelationalOperation {
    private final String name;
    private final List<String> columns;

    Renaming(String name, List<String> columns, Relation relation) {
        super(relation);
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public List<String> getColumns() {
        return columns;
    }
}
