package com.kakaopage.crm.extraction.athena;

abstract class Statement {

    private StatementContext context = new StatementContext();

    StatementContext getContext() {
        return context;
    }
}
