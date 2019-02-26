package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("∩")
public class Intersection extends BinaryRelationalAlgebraOperator {

    public Intersection(Relation first, Relation second) {
        super(first, second);
    }
}
