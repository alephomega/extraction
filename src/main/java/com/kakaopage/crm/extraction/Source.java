package com.kakaopage.crm.extraction;

public class Source {
    private final String id;
    private final long count;
    private final String database;
    private final String table;

    public Source(String id, long count, String database, String table) {
        this.id = id;
        this.count = count;
        this.database = database;
        this.table = table;
    }
}
