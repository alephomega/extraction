package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("sumOf")
public class SumOf extends ArrayFunction {
    private final Class type;

    public SumOf(Function array, Class type) {
        super(array);
        this.type = type;
    }

    public Class getType() {
        return type;
    }
}
