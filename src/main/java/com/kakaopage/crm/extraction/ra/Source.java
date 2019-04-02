package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;

public class Source extends Relation {
    private final Type type;
    private final Predicate pushDown;

    public Source(String name, Predicate pushDown) {
        this(name, Type.User, pushDown);
    }

    private Source(String name, Type type, Predicate pushDown) {
        super(name);
        this.type = type;
        this.pushDown = pushDown;
    }


    public static Relation system(String name, Predicate pushDown) {
        return new Source(name, Type.System, pushDown);
    }

    public static Relation user(String name, Predicate pushDown) {
        return new Source(name, Type.User, pushDown);
    }

    public Type getType() {
        return type;
    }

    public Predicate getPushDown() {
        return pushDown;
    }

    public enum Type {
        System,
        User,
        Intermediate;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
}