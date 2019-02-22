package com.kakaopage.global.crm.extraction;

public class Step {
    private final String name;
    private final Step[] dependencies;
    private final Operation operation;

    public Step(String name, Step[] dependencies, Operation operation) {
        this.name = name;
        this.dependencies = dependencies;
        this.operation = operation;
    }

    public Step[] depends() {
        return dependencies;
    }

    public String getName() {
        return name;
    }

    public Operation getOperation() {
        return operation;
    }
}