package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.Predicate;

@Symbol("σ")
public class Selection extends UnaryRelationalAlgebraOperator {
    private final Predicate condition;

    Selection(Predicate condition, Relation relation) {
        super(relation);
        this.condition = condition;
    }

    public Predicate getCondition() {
        return condition;
    }

    public static class Parameters {
        private final Predicate condition;

        public Parameters(Predicate condition) {
            this.condition = condition;
        }
    }
}
