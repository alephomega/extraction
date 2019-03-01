package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.Schema;
import com.kakaopage.crm.extraction.ra.Selection;

import java.util.List;
import java.util.stream.Collectors;

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
        Schema schema = relation.getSchema();
        List<Schema.Attribute> attributes = schema.getAttributes();

        return attributes.stream().map(attribute -> new SelectExpression(new Value(attribute.getName()), attribute.getName())).collect(Collectors.toList());
    }
}