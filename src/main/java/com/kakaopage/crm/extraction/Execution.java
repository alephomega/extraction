package com.kakaopage.crm.extraction;

public class Execution {
    private final String id;
    private final String job;
    private final String at;

    public Execution(String id, String job, String at) {
        this.id = id;
        this.job = job;
        this.at = at;
    }

    public String getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public String getAt() {
        return at;
    }
}
