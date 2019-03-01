package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Predicate;

public class Where extends Clause {
    private final Predicate condition;

    public Where(Predicate condition) {
        this.condition = condition;
    }

    public Predicate getCondition() {
        return condition;
    }

    @Override
    public String stringify(StatementContext context) {
        return null;
    }
}
