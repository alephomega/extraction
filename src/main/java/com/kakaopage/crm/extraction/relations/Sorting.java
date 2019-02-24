package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

import java.util.List;

@Operator("τ")
public class Sorting extends UnaryRelationalOperation {
    private final List<ColumnOrdering> orderings;

    public Sorting(List<ColumnOrdering> orderings, Relation relation) {
        super(relation);
        this.orderings = orderings;
    }

    public List<ColumnOrdering> getOrderings() {
        return orderings;
    }
}
