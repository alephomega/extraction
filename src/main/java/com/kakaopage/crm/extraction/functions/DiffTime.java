package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("diff")
public class DiffTime implements Function {
    private final Function _1;
    private final Function _2;
    private final String unit;

    public DiffTime(Function _1, Function _2, String unit) {
        this._1 = _1;
        this._2 = _2;

        this.unit = unit;
    }

    public Function firstTime() {
        return _1;
    }

    public Function secondTime() {
        return _2;
    }

    public String getUnit() {
        return unit;
    }
}
