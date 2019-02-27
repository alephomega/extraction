package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;
import com.kakaopage.crm.extraction.ra.Selection;

import java.util.ArrayList;
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
        List<Column> columns = new ArrayList<>();
        Column col1 = new Column();
        col1.setFunction(new Value("customer"));
        col1.setName("customer");
        columns.add(col1);

        Column col2 = new Column();
        col2.setFunction(new Value("event"));
        col2.setName("event");
        columns.add(col2);

        Column col3 = new Column();
        col3.setFunction(new Value("frequency"));
        col3.setName("frequency");
        columns.add(col3);

        Column col4 = new Column();
        col4.setFunction(new Value("event.at"));
        col4.setName("event.at");
        columns.add(col4);

        Column col5 = new Column();
        col5.setFunction(new Value("event.meta"));
        col5.setName("event.meta");
        columns.add(col5);

        return columns;
    }
}