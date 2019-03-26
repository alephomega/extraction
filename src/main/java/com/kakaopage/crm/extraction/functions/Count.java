package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("count")
public class Count extends AggregateFunction {

    public Count(Function function) {
        super(function);
    }

    @Override
    public void validate() throws InvalidExpressionException {
        Function function = getFunction();
        if (function == null) {
            throw new InvalidExpressionException("function argument must not be null");
        }

        function.validate();
    }
}