package com.kakaopage.crm.extraction.ra.relations;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationType;

@RelationType("source")
public class Source extends Relation {
    private final Predicate pushDown;

    public Source(String name, Predicate pushDown) {
        super(name);
        this.pushDown = pushDown;
    }

    public Predicate getPushDown() {
        return pushDown;
    }
}