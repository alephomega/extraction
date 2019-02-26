package com.kakaopage.crm.extraction.relations;


import com.kakaopage.crm.extraction.Symbol;

@Symbol("⨯")
public class Product extends BinaryRelationalAlgebraOperator {

    public Product(Relation _1, Relation _2) {
        super(_1, _2);
    }
}
