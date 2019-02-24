package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("∪")
public class Union extends BinaryRelationalOperation {

    public Union(Relation first, Relation second) {
        super(first, second);
    }
}
