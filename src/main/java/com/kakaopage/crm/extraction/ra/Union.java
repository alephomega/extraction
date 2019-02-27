package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("∪")
public class Union extends BinaryRelationalAlgebraOperator {

    public Union(Relation first, Relation second) {
        super(first, second);
    }
}
