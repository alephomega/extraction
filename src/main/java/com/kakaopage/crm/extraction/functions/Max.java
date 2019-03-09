package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("max")
public class Max extends AggregateFunction {

    public Max(Function function) {
        super(function);
    }
}
