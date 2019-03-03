package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("⟕")
public class LeftOuterJoin extends Join {

    public LeftOuterJoin(Predicate condition, Relation first, Relation second) {
        super(condition, first, second);
    }
}
