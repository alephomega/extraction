package com.kakaopage.crm.extraction.relations;

import java.util.ArrayList;
import java.util.List;

public class BinaryRelationalAlgebraOperator implements RelationalAlgebraOperator {
    private final Relation _1;
    private final Relation _2;

    public BinaryRelationalAlgebraOperator(Relation _1, Relation _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public Relation getFirstRelation() {
        return _1;
    }

    public Relation getSecondRelation() {
        return _2;
    }

    @Override
    public List<?> getOperands() {
        List<Object> operands = new ArrayList<>();
        operands.add(_1);
        operands.add(_2);

        return operands;
    }
}
