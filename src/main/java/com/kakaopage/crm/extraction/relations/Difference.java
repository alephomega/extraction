package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operator;

@Operator("-")
public class Difference extends BinaryRelationalOperation {

    public Difference(Relation first, Relation second) {
        super(first, second);
    }
}
