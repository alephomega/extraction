package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.PushDown;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.UnaryOperator;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Symbol("∧")
public class Conjunction extends UnaryOperator<List<Predicate>> implements LogicalOperator {

    public Conjunction(List<Predicate> predicates) {
        super(predicates);
    }

    public List<Predicate> getPredicates() {
        return getSingleOperand();
    }

    @Override
    public String toPushDownExpression() {
        return String.format("(%s)", StringUtils.join(getPredicates().stream().map(PushDown::toPushDownExpression).toArray(), " and "));
    }
}
