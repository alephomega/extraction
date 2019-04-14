package com.kakaopage.crm.extraction.ra.relations;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationType;

@RelationType("source")
public class Source extends Relation {
    private final Predicate pushDown;
    private final boolean managed;

    public Source(String name, Predicate pushDown, boolean managed) {
        super(name);
        this.pushDown = pushDown;
        this.managed = managed;
    }

    public Predicate getPushDown() {
        return pushDown;
    }

    public boolean isManaged() {
        return managed;
    }
}