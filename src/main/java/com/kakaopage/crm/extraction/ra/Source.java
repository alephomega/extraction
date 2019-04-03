package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;

public class Source extends Relation {
    private final Type type;
    private final Predicate pushDown;

    public Source(String name, Predicate pushDown) {
        this(name, Type.User, pushDown);
    }

    public Source(String name, Type type, Predicate pushDown) {
        super(name);
        this.type = type;
        this.pushDown = pushDown;
    }


    public static Source system(String name, Predicate pushDown) {
        return new Source(name, Type.System, pushDown);
    }

    public static Source user(String name, Predicate pushDown) {
        return new Source(name, Type.User, pushDown);
    }

    public static Source temporary(String name, Predicate pushDown) {
        return new Source(name, Type.Temporary, pushDown);
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
        Temporary;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
}