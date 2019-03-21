package com.kakaopage.crm.extraction;

import java.util.List;

public class ProcessDescription {
    private final String id;
    private final String time;
    private final List<Assignment> assignments;
    private final Sink sink;

    public ProcessDescription(String id, String time, List<Assignment> assignments, Sink sink) {
        this.id = id;
        this.time = time;
        this.assignments = assignments;
        this.sink = sink;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public Sink getSink() {
        return sink;
    }
}