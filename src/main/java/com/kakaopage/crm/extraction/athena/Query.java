package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.functions.Alias;

abstract class Query {

    private QueryContext context = new QueryContext();

    QueryContext getContext() {
        return context;
    }

    static Column toColumn(Alias alias) {
        Column column = new Column();
        column.setFunction(alias.getFunction());
        column.setName(alias.getAlias());

        return column;
    }
}
