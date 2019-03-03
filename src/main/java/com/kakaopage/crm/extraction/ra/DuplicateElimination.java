package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("δ")
public class DuplicateElimination extends UnaryRelationalAlgebraOperator {

    public DuplicateElimination(Relation relation) {
        super(relation);
    }
}
