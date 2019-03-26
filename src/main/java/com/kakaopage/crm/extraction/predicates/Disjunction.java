package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Symbol("∨")
public class Disjunction extends UnaryOperator<List<Predicate>> implements LogicalOperator {
    public Disjunction(List<Predicate> predicates) {
        super(predicates);
    }

    public List<Predicate> getPredicates() {
        return getSingleOperand();
    }

    @Override
    public String toPushDownExpression() {
        return String.format("(%s)", StringUtils.join(getPredicates().stream().map(PushDown::toPushDownExpression).toArray(), " or "));
    }

    @Override
    public void validate() throws InvalidExpressionException {
        List<Predicate> predicates = getPredicates();
        if (predicates == null || predicates.isEmpty()) {
            throw new InvalidExpressionException("predicates argument must not be empty");
        }

        predicates.forEach(Predicate::validate);
    }
}
