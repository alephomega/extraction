package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;

public class Relation {
    private final String name;
    private final Predicate pushDown;

    public Relation(String name, Predicate pushDown) {
        this.name = name;
        this.pushDown = pushDown;
    }

    public String getName() {
        return name;
    }

    public Predicate getPushDown() {
        return pushDown;
    }
}