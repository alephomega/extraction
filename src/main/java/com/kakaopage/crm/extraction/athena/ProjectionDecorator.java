package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Alias;
import com.kakaopage.crm.extraction.ra.Projection;
import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;

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

        List<Column> columns = new ArrayList<>(attributes.size());
        for (Function function : attributes) {
            columns.add(Query.toColumn((Alias) function));
        }

        select.setColumns(columns);

        return select;
    }
}