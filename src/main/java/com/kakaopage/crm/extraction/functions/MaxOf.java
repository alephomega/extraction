package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("max_of")
public class MaxOf extends ArrayFunction {

    public MaxOf(Function array) {
        super(array);
    }
}
