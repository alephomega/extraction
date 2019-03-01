package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Alias;
import com.kakaopage.crm.extraction.ra.Projection;

import java.util.List;

public class ProjectionDecorator implements StatementDecorator<SelectStatement, Projection> {

    @Override
    public SelectStatement build(SelectStatement statement, Projection projection) {
        List<Function> attributes = projection.getAttributes();
        if (attributes.isEmpty()) {
            return statement;
        }

        Select select = statement.getSelect();
        select.removeAll();

        for (Function function : attributes) {
            Alias alias = (Alias) function;
            select.add(alias.getFunction(), alias.getName());
        }

        return statement;
    }
}