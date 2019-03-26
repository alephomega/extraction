package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("sum_of")
public class SumOf extends ArrayFunction {

    public SumOf(Function array) {
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
