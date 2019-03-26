package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Expression;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

public class Aggregation implements Expression {
    private final Function function;
    private final String alias;


    public Aggregation(Function function, String alias) {
        this.function = function;
        this.alias = alias;
    }

    public Function getFunction() {
        return function;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (function == null) {
            throw new InvalidExpressionException("by field must not be null");
        }

        function.validate();

        if (StringUtils.isEmpty(alias)) {
            throw new InvalidExpressionException("alias field must not be empty");
        }
    }
}