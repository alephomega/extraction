package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("time")
public class Time implements Function {
    private final Function text;

    public Time(Function text) {
        this.text = text;
    }

    public Function getText() {
        return text;
    }
}
