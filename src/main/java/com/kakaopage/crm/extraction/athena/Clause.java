package com.kakaopage.crm.extraction.athena;

public abstract class Clause {
    public abstract String stringify(StatementContext context);
}
