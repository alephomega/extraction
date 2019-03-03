package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("⟗")
public class FullOuterJoin extends Join {

    public FullOuterJoin(Predicate condition, Relation first, Relation second) {
        super(condition, first, second);
    }
}
