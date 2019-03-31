package com.kakaopage.crm.extraction;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Process implements Expression {
    private final String name;
    private final int interval;
    private final List<Assignment> assignments;
    private final Sink sink;

    public Process(String name, int interval, List<Assignment> assignments, Sink sink) {
        this.name = name;
        this.interval = interval;
        this.assignments = assignments;
        this.sink = sink;
    }

    public String getName() {
        return name;
    }

    public int getInterval() {
        return interval;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public Sink getSink() {
        return sink;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidExpressionException("id field must not be empty");
        }

        if (assignments == null || assignments.isEmpty()) {
            throw new InvalidExpressionException("assignments field must not be empty");
        }

        assignments.forEach(Assignment::validate);

        sink.validate();
    }
}
