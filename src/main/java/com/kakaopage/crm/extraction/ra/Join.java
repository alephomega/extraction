package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("⨝")
public class Join extends BinaryRelationalAlgebraOperator {

    public Join(Relation first, Relation second) {
        super(first, second);
    }
}