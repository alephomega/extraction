package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("count")
public class Count extends AggregateFunction {

    public Count(Function function) {
        super(function);
    }
}
