package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("some")
public class Some implements Function {
    private final Function of;

    public Some(Function of) {
        this.of = of;
    }

    public Function getOf() {
        return of;
    }
}
