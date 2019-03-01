package com.kakaopage.crm.extraction.athena;

public class As extends Clause {
    private final String name;

    public As(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String stringify(StatementContext context) {
        return null;
    }
}