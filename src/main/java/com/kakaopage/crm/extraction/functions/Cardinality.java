package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("cardinality")
public class Cardinality extends ArrayFunction {

    public Cardinality(Function array) {
        super(array);
    }
}
