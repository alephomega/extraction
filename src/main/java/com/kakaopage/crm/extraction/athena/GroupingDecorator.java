package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Alias;
import com.kakaopage.crm.extraction.relations.Grouping;
import com.kakaopage.crm.extraction.relations.RelationalAlgebraOperator;

import java.util.List;

public class GroupingDecorator implements QueryDecorator<Select> {

    @Override
    public Select build(Select select, RelationalAlgebraOperator operation) {
        if (!Grouping.class.isAssignableFrom(operation.getClass())) {
            return select;
        }

        Grouping grouping = (Grouping) operation;
        List<Function> groupBy = grouping.getGroupBy();

        for (Function element : groupBy) {
            Alias alias = (Alias) element;

            Function by = alias.getFunction();
            String name = alias.getAlias();


        }

        return select;
    }
}
