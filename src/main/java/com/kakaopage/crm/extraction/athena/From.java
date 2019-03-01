package com.kakaopage.crm.extraction.athena;

public class From extends Clause {
    private final String table;

    public From(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    @Override
    public String stringify(StatementContext context) {
        return String.format("from %s", table);
    }
}
