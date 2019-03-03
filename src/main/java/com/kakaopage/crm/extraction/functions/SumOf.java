package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("sumOf")
public class SumOf extends ArrayFunction {

    public SumOf(Function array) {
        super(array);
    }
}
