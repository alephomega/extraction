package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.InvalidExpressionException;

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

    @Override
    public void validate() throws InvalidExpressionException {
        if (_1 == null) {
            throw new InvalidExpressionException("_1 argument must not be null");
        }

        _1.validate();
    }
}