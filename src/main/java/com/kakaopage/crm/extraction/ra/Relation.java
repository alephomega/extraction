package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Expression;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

public abstract class Relation implements Expression {
    private final String name;

    public Relation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidExpressionException("name field must not be empty");
        }
    }
}