package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("explode")
public class Explode extends ArrayFunction {

    public Explode(Function array) {
        super(array);
    }
}
