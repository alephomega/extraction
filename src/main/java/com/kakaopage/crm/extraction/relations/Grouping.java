package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.functions.Alias;

import java.util.List;
import java.util.stream.Collectors;

@Symbol("γ")
public class Grouping extends UnaryRelationalAlgebraOperator {
    private final List<Function> groupBy;
    private final List<Function> aggregations;

    public Grouping(List<Alias> groupBy, List<Alias> aggregations, Relation relation) {
        super(relation);
        this.groupBy = groupBy.stream().collect(Collectors.toList());
        this.aggregations = aggregations.stream().collect(Collectors.toList());
    }

    public List<Function> getGroupBy() {
        return groupBy;
    }

    public List<Function> getAggregations() {
        return aggregations;
    }
}