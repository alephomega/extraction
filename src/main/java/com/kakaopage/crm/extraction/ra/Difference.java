package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;

@Symbol("-")
public class Difference extends BinaryRelationalAlgebraOperator {

    public Difference(Relation first, Relation second) {
        super(first, second);
    }
}
