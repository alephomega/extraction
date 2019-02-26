package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Alias;
import com.kakaopage.crm.extraction.relations.Projection;
import com.kakaopage.crm.extraction.relations.RelationalAlgebraOperator;

import java.util.ArrayList;
import java.util.List;

public class ProjectionDecorator implements QueryDecorator<Select> {

    @Override
    public Select build(Select select, RelationalAlgebraOperator operation) {
        if (!Projection.class.isAssignableFrom(operation.getClass())) {
            return select;
        }

        Projection projection = (Projection) operation;

        List<Function> attributes = projection.getAttributes();
        if (attributes.isEmpty()) {
            return select;
        }

        QueryContext context = select.getContext();
        List<Column> columns = new ArrayList<>(attributes.size());
        for (Function attribute : attributes) {
            Alias alias = (Alias) attribute;

            Column column = new Column();
            column.setFunction(alias.getFunction());
            column.setAlias(alias.getAlias());

            columns.add(column);
        }

        select.setColumns(columns);

        return select;
    }
}