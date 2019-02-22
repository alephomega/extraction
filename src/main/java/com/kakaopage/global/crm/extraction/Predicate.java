package com.kakaopage.global.crm.extraction;

public abstract class Predicate<T> implements Operation {

    private final T value;

    protected Predicate(T value) {
        this.value = value;
    }
}
