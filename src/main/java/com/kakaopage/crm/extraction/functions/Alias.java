package com.kakaopage.crm.extraction.functions;


import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("as")
public class Alias implements Function {
    private final Function function;
    private final String name;

    public Alias(Function function, String name) {
        this.function = function;
        this.name = name;
    }

    public Function getFunction() {
        return function;
    }

    public String getName() {
        return name;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (function == null) {
            throw new InvalidExpressionException("function argument must not be null");
        }

        if (StringUtils.isEmpty(name)) {
            throw new InvalidExpressionException("name argument must not be empty");
        }

        function.validate();
    }
}
