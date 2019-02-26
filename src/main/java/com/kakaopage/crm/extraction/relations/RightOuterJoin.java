package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("⟖")
public class RightOuterJoin extends BinaryRelationalAlgebraOperator {

    public RightOuterJoin(Relation first, Relation second) {
        super(first, second);
    }
}
