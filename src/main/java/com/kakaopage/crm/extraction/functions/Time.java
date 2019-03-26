package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("time")
public class Time implements Function {
    private final Function text;

    public Time(Function text) {
        this.text = text;
    }

    public Function getText() {
        return text;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (text == null) {
            throw new InvalidExpressionException("text argument must not be null");
        }

        text.validate();
    }
}
