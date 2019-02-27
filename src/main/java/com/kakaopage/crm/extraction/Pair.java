package com.kakaopage.crm.extraction;

public class Pair<F, S> {
    private final F _1;
    private final S _2;

    public Pair(F _1, S _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public F first() {
        return _1;
    }

    public S second() {
        return _2;
    }
}