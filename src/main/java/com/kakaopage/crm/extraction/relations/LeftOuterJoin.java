package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("⟕")
public class LeftOuterJoin extends BinaryRelationalOperation {

    public LeftOuterJoin(Relation first, Relation second) {
        super(first, second);
    }
}
