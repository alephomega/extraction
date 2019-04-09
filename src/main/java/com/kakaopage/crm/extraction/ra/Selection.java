package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.ra.relations.Source;

@Symbol("σ")
public class Selection extends UnaryRelationalAlgebraOperator {
    private final Predicate condition;

    public Selection(Predicate condition, Source source) {
        super(source);
        this.condition = condition;
    }

    public Predicate getCondition() {
        return condition;
    }

    public Source getSource() {
        return (Source) getRelation();
    }
}