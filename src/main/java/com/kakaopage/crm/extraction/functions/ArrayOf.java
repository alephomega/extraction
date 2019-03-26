package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Expression;
import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

import java.util.List;

@FuncIdentifier("array_of")
public class ArrayOf implements Function {
    private final List<Function> elements;

    public ArrayOf(List<Function> elements) {
        this.elements = elements;
    }

    public List<Function> getElements() {
        return elements;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (elements == null) {
            throw new InvalidExpressionException("elements argument must not be null");
        }

        elements.forEach(Expression::validate);
    }
}
