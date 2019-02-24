package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("⟗")
class FullOuterJoin extends BinaryRelationalOperation {

    public FullOuterJoin(Relation first, Relation second) {
        super(first, second);
    }
}
