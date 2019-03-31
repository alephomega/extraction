package com.kakaopage.crm.extraction;

public class Execution {
    private final String id;
    private final String job;

    public Execution(String id, String job) {
        this.id = id;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public String getJob() {
        return job;
    }
}
