package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("⟕")
public class LeftOuterJoin extends BinaryRelationalAlgebraOperator {

    public LeftOuterJoin(Relation first, Relation second) {
        super(first, second);
    }
}
