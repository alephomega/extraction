package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Expression;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

public class GroupingElement implements Expression {
    private final Function by;
    private final String alias;

    public GroupingElement(Function by, String alias) {
        this.by = by;
        this.alias = alias;
    }

    public Function getBy() {
        return by;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (by == null) {
            throw new InvalidExpressionException("by field must not be null");
        }

        by.validate();

        if (StringUtils.isEmpty(alias)) {
            throw new InvalidExpressionException("alias field must not be empty");
        }
    }
}
