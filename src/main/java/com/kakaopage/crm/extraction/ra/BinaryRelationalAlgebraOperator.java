package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

import java.util.ArrayList;
import java.util.List;

public class BinaryRelationalAlgebraOperator implements RelationalAlgebraOperator {
    private final Relation _1;
    private final Relation _2;

    public BinaryRelationalAlgebraOperator(Relation _1, Relation _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public Relation firstRelation() {
        return _1;
    }

    public Relation secondRelation() {
        return _2;
    }

    @Override
    public List<?> getOperands() {
        List<Object> operands = new ArrayList<>();
        operands.add(_1);
        operands.add(_2);

        return operands;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (_1 == null) {
            throw new InvalidExpressionException("_1 argument must not be null");
        }

        if (_2 == null) {
            throw new InvalidExpressionException("_2 argument must not be null");
        }

        _1.validate();
        _2.validate();
    }
}
