package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("minOf")
public class MinOf extends ArrayFunction {
    public MinOf(Function array) {
        super(array);
    }
}
