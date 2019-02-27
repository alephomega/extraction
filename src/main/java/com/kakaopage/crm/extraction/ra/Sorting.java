package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;

import java.util.List;

@Symbol("τ")
public class Sorting extends UnaryRelationalAlgebraOperator {
    private final List<ColumnOrdering> orderings;

    public Sorting(List<ColumnOrdering> orderings, Relation relation) {
        super(relation);
        this.orderings = orderings;
    }

    public List<ColumnOrdering> getOrderings() {
        return orderings;
    }
}
