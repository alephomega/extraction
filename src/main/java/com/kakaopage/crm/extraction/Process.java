package com.kakaopage.crm.extraction;

import java.util.List;

public class Process {
    private final List<Assignment> assignments;
    private final Sink sink;

    public Process(List<Assignment> assignments, Sink sink) {
        this.assignments = assignments;
        this.sink = sink;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public Sink getSink() {
        return sink;
    }
}
