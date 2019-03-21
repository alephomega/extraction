package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Expression;
import com.kakaopage.crm.extraction.Function;

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
}
