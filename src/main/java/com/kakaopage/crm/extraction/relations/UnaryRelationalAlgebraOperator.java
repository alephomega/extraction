package com.kakaopage.crm.extraction.relations;

import java.util.Collections;
import java.util.List;

class UnaryRelationalAlgebraOperator implements RelationalAlgebraOperator {

    private final Relation _1;

    UnaryRelationalAlgebraOperator(Relation _1) {
        this._1 = _1;
    }

    public Relation getRelation() {
        return _1;
    }

    @Override
    public List<?> getOperands() {
        return Collections.singletonList(_1);
    }
}