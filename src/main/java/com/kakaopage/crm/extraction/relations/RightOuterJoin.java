package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("⟖")
public class RightOuterJoin extends BinaryRelationalOperation {

    public RightOuterJoin(Relation first, Relation second) {
        super(first, second);
    }
}
