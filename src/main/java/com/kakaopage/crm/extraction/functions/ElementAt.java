package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("element_at")
public class ElementAt extends ArrayFunction {

    private final int index;

    public ElementAt(Function array, int index) {
        super(array);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        Function array = getArray();
        if (array == null) {
            throw new InvalidExpressionException("array argument must not be null");
        }

        array.validate();

        if (index < 0) {
            throw new InvalidExpressionException("index argument must be greater than or equal to 0");
        }
    }
}
