package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.Selection;

import java.util.List;

public class SelectionDecorator implements StatementDecorator<SelectStatement, Selection> {

    @Override
    public SelectStatement build(SelectStatement statement, Selection selection) {
        Select select = new Select();

        statement.setSelect(select);

        Relation relation = selection.getRelation();
        statement.setFrom(new From(relation.getName()));

        statement.setWhere(new Where(selection.getCondition()));

        return statement;
    }

    private List<SelectExpression> all(Relation relation) {
//        Schema schema = relation.getSchema();
//        List<Schema.Attribute> attributes = schema.getAttributes();

        return null;
    }
}