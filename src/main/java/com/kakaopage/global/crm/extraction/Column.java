package com.kakaopage.global.crm.extraction;

public class Column {
    private final String name;
    private final String database;
    private final String table;

    public Column(String name, String database, String table) {
        this.name = name;
        this.database = database;
        this.table = table;
    }
}
