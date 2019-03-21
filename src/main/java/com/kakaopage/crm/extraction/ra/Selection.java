package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("σ")
public class Selection extends UnaryRelationalAlgebraOperator {
    private final Predicate condition;
    private final Source _1;

    public Selection(Predicate condition, Source source) {
        super(source);
        this._1 = source;
        this.condition = condition;
    }

    public Predicate getCondition() {
        return condition;
    }

    public Source getSource() {
        return _1;
    }
}