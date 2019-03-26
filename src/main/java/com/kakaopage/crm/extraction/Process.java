package com.kakaopage.crm.extraction;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Process implements Expression {
    private final String id;
    private final String time;
    private final List<Assignment> assignments;
    private final Sink sink;

    public Process(String id, String time, List<Assignment> assignments, Sink sink) {
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

    @Override
    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(id)) {
            throw new InvalidExpressionException("id field must not be empty");
        }

        if (StringUtils.isEmpty(time)) {
            throw new InvalidExpressionException("time field must not be empty");
        }

        if (assignments == null || assignments.isEmpty()) {
            throw new InvalidExpressionException("assignments field must not be empty");
        }

        assignments.forEach(Assignment::validate);

        sink.validate();
    }
}
