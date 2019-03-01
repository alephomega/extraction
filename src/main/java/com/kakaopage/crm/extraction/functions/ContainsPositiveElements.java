package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("containsPositive")
public class ContainsPositiveElements extends ArrayFunction {

    public ContainsPositiveElements(Function array) {
        super(array);
    }
}