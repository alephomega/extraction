package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("some")
public class Some implements Function {
    private final Value of;

    public Some(Value of) {
        this.of = of;
    }

    public Function getOf() {
        return of;
    }
}
