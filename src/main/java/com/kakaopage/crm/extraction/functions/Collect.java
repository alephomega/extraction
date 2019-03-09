package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("collect")
public class Collect extends AggregateFunction {
    private final boolean duplicated;

    public Collect(Function function, boolean duplicated) {
        super(function);
        this.duplicated = duplicated;
    }

    public boolean isDuplicated() {
        return duplicated;
    }
}
