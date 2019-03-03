package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.functions.Alias;

import java.util.List;
import java.util.stream.Collectors;

@Symbol("γ")
public class Grouping extends UnaryRelationalAlgebraOperator {
    private final List<GroupingElement> groupBy;
    private final List<Aggregation> aggregations;

    public Grouping(List<Alias> groupBy, List<Alias> aggregations, Relation relation) {
        super(relation);
        this.groupBy = groupBy.stream().map(a -> new GroupingElement(a.getFunction(), a.getName())).collect(Collectors.toList());
        this.aggregations = aggregations.stream().map(a -> new Aggregation(a.getFunction(), a.getName())).collect(Collectors.toList());
    }

    public List<GroupingElement> getGroupBy() {
        return groupBy;
    }

    public List<Aggregation> getAggregations() {
        return aggregations;
    }
}