package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.UnaryOperator;

import java.util.List;

@Symbol("∧")
public class Conjunction extends UnaryOperator<List<Predicate>> implements LogicalOperator {

    public Conjunction(List<Predicate> predicates) {
        super(predicates);
    }

    public List<Predicate> getPredicates() {
        return getSingleOperand();
    }
}
