package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("∩")
public class Intersection extends BinaryRelationalOperation {

    public Intersection(Relation first, Relation second) {
        super(first, second);
    }
}
