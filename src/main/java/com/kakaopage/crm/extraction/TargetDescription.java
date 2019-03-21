package com.kakaopage.crm.extraction;

public class TargetDescription {
    private final String job;
    private final String execution;
    private final long size;
    private final String database;
    private final String table;
    private final String predicate;

    public TargetDescription(String job, String execution, long size, String database, String table, String predicate) {
        this.job = job;
        this.execution = execution;
        this.size = size;
        this.database = database;
        this.table = table;
        this.predicate = predicate;
    }

    public String getJob() {
        return job;
    }

    public String getExecution() {
        return execution;
    }

    public long getSize() {
        return size;
    }

    public String getDatabase() {
        return database;
    }

    public String getTable() {
        return table;
    }

    public String getPredicate() {
        return predicate;
    }
}