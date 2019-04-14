package com.kakaopage.crm.extraction;

import com.google.gson.annotations.SerializedName;

public class Job {
    private final String id;

    @SerializedName("jobName")
    private final String name;

    @SerializedName("relationExp")
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
