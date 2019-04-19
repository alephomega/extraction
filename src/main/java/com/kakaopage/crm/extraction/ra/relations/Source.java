package com.kakaopage.crm.extraction.ra.relations;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Split;
import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationType;

@RelationType("source")
public class Source extends Relation {
    private final Predicate pushDown;
    private final Boolean managed;
    private final Split split;

    public Source(String name, Predicate pushDown, boolean managed, Split split) {
        super(name);
        this.pushDown = pushDown;
        this.managed = managed;
        this.split = split;
    }

    public Predicate getPushDown() {
        return pushDown;
    }

    public boolean isManaged() {
        return managed == null || managed;
    }

    public Split getSplit() {
        return split;
    }
}