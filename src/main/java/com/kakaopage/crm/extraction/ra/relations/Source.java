package com.kakaopage.crm.extraction.ra.relations;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationType;

@RelationType("source")
public class Source extends Relation {
    private final Group group;
    private final Predicate pushDown;

    public Source(String name, Predicate pushDown) {
        this(name, Group.User, pushDown);
    }

    public Source(String name, Group group, Predicate pushDown) {
        super(name);
        this.group = group;
        this.pushDown = pushDown;
    }


    public static Source system(String name, Predicate pushDown) {
        return new Source(name, Group.System, pushDown);
    }

    public static Source user(String name, Predicate pushDown) {
        return new Source(name, Group.User, pushDown);
    }


    public Group getGroup() {
        return group;
    }

    public Predicate getPushDown() {
        return pushDown;
    }

    public enum Group {
        System,
        User,
        Temporary;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
}