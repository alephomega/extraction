package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Operator;

import java.util.List;

@Operator("γ")
public class Grouping extends UnaryRelationalOperation {
    private final List<String> by;
    private final List<Function> aggregations;

    public Grouping(List<String> by, List<Function> aggregations, Relation relation) {
        super(relation);
        this.by = by;
        this.aggregations = aggregations;
    }

    public List<String> getBy() {
        return by;
    }

    public List<Function> getAggregations() {
        return aggregations;
    }
}