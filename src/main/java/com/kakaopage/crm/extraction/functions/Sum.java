package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("sum")
public class Sum extends AggregateFunction{

    public Sum(Function function) {
        super(function);
    }
}
