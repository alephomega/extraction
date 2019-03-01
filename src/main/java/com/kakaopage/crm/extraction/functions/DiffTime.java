package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

import java.util.concurrent.TimeUnit;

public class DiffTime implements Function {
    private final Function _1;
    private final Function _2;
    private final TimeUnit unit;

    public DiffTime(Function _1, Function _2, TimeUnit unit) {
        this._1 = _1;
        this._2 = _2;

        this.unit = unit;
    }

    public Function firsTime() {
        return _1;
    }

    public Function secondTime() {
        return _2;
    }

    public TimeUnit getUnit() {
        return unit;
    }
}
