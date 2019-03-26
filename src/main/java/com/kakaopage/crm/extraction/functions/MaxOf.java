package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("max_of")
public class MaxOf extends ArrayFunction {

    public MaxOf(Function array) {
        super(array);
    }

    @Override
    public void validate() throws InvalidExpressionException {
        Function array = getArray();
        if (array == null) {
            throw new InvalidExpressionException("array argument must not be null");
        }

        array.validate();
    }
}
