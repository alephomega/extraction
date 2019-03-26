package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("now")
public class Now implements Function {

    @Override
    public void validate() throws InvalidExpressionException {

    }
}
