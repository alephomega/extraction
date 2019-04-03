package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("⟖")
public class RightOuterJoin extends Join {

    public RightOuterJoin(Predicate condition, Relation first, Relation second) {
        super(condition, true, first, second);
    }
}
