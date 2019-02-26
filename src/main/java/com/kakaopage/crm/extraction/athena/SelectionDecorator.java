package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.relations.RelationalAlgebraOperator;
import com.kakaopage.crm.extraction.relations.Selection;

import java.util.List;

public class SelectionDecorator implements QueryDecorator<Select> {

    @Override
    public Select build(Select select, RelationalAlgebraOperator operation) {
        if (!Selection.class.isAssignableFrom(operation.getClass())) {
            return select;
        }

        Selection selection = (Selection) operation;
        select.setColumns(all());
        select.setFrom(selection.getRelation());
        select.setCondition(selection.getCondition());

        return select;
    }

    private List<Column> all() {
        return null;
    }
}
