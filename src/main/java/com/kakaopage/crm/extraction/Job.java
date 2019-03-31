package com.kakaopage.crm.extraction;

public class Job {
    private final String id;
    private final String name;
    private final String expression;

    public Job(String id, String name, String expression) {
        this.id = id;
        this.name = name;
        this.expression = expression;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpression() {
        return expression;
    }
}
