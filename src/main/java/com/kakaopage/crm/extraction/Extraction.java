package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

public class Extraction implements Expression {
    private final static Gson GSON =  new GsonBuilder().registerTypeAdapter(Function.class, new FunctionJsonDeserializer())
            .registerTypeAdapter(Predicate.class, new PredicateJsonDeserializer())
            .registerTypeAdapter(Assignment.class, new AssignmentJsonDeserializer())
            .create();

    private final String job;
    private final String execution;
    private final Process process;

    public Extraction(String job, String execution, Process process) {
        this.job = job;
        this.execution = execution;
        this.process = process;
    }

    public String getJob() {
        return job;
    }

    public String getExecution() {
        return execution;
    }

    public Process getProcess() {
        return process;
    }

    public static Extraction of(String description) {
        Extraction extraction = GSON.fromJson(description, Extraction.class);
        extraction.validate();

        return extraction;
    }

    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(job)) {
            throw new InvalidExpressionException("job field must not be empty");
        }

        if (StringUtils.isEmpty(execution)) {
            throw new InvalidExpressionException("execution field must not be empty");
        }

        process.validate();
    }
}