package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("min")
public class Min extends AggregateFunction {

    public Min(Function function) {
        super(function);
    }
}
