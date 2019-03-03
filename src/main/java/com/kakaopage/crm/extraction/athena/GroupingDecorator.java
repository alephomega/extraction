package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.functions.Alias;
import com.kakaopage.crm.extraction.ra.Grouping;

import java.util.stream.Stream;

public class GroupingDecorator implements StatementDecorator<SelectStatement, Grouping> {

    @Override
    public SelectStatement build(SelectStatement statement, Grouping grouping) {
        Select select = statement.getSelect();
        select.removeAll();

        Stream.concat(grouping.getGroupBy().stream().map(g -> new Alias(g.getBy(), g.getAlias())), grouping.getAggregations().stream().map(a -> new Alias(a.getFunction(), a.getAlias())))
                .forEach(function -> {
                    Alias alias = (Alias) function;
                    select.add(alias.getFunction(), alias.getName());
                });

        return statement;
    }
}