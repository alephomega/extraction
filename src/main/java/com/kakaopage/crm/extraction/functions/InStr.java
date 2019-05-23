package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;


@FuncIdentifier("instr")
public class InStr implements Function {
    private final Function str;
    private final String substr;

    public InStr(Function str, String substr) {
        this.str = str;
        this.substr = substr;
    }

    public Function getStr() {
        return str;
    }

    public String getSubstr() {
        return substr;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (str == null) {
            throw new InvalidExpressionException("str argument must not be null");
        }

        str.validate();

        if (StringUtils.isEmpty(substr)) {
            throw new InvalidExpressionException("substr argument must not be empty");
        }
    }
}
