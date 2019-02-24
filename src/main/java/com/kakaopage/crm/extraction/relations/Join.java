package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("⨝")
public class Join extends BinaryRelationalOperation {

    public Join(Relation first, Relation second) {
        super(first, second);
    }
}
