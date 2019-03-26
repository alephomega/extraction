package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("collect")
public class Collect extends AggregateFunction {
    private final boolean duplicated;

    public Collect(Function function, boolean duplicated) {
        super(function);
        this.duplicated = duplicated;
    }

    public boolean isDuplicated() {
        return duplicated;
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
