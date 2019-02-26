package com.kakaopage.crm.extraction.athena;

abstract class Query {

    private QueryContext context;

    QueryContext getContext() {
        return context;
    }
}
