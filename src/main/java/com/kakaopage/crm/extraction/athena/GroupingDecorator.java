package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.functions.Alias;
import com.kakaopage.crm.extraction.ra.Grouping;
import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingDecorator implements QueryDecorator<Select> {

    @Override
    public Select build(Select select, RelationalAlgebraOperator operation) {
        if (!Grouping.class.isAssignableFrom(operation.getClass())) {
            return select;
        }

        Grouping grouping = (Grouping) operation;
        List<Column> columns = Stream.concat(grouping.getGroupBy().stream(), grouping.getAggregations().stream())
                .map(function -> Query.toColumn((Alias) function)).collect(Collectors.toList());

        select.setColumns(columns);

        return select;
    }
}