package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

@FuncIdentifier("contains")
public class Contains<T> extends ArrayFunction {
    private final T value;

    public Contains(Function array, T value) {
        super(array);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (value == null) {
            throw new InvalidExpressionException("value argument must not be null");
        }
    }
}