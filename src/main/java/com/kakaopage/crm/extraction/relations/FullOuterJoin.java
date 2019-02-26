package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("⟗")
class FullOuterJoin extends BinaryRelationalAlgebraOperator {

    public FullOuterJoin(Relation first, Relation second) {
        super(first, second);
    }
}
