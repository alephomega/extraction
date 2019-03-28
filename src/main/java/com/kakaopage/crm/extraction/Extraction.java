package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

public class Extraction implements Expression {

    private final static Gson GSON =  new GsonBuilder().registerTypeAdapter(Function.class, new FunctionJsonDeserializer())
            .registerTypeAdapter(Predicate.class, new PredicateJsonDeserializer())
            .registerTypeAdapter(Assignment.class, new AssignmentJsonDeserializer())
            .create();

    private final String id;
    private final String job;
    private final Process process;

    public Extraction(String id, String job, Process process) {
        this.id = id;
        this.job = job;
        this.process = process;
    }

    public String getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public Process getProcess() {
        return process;
    }

    public static Extraction of(String id, String job, String expression) {
        Extraction extraction = new Extraction(id, job, GSON.fromJson(expression, Process.class));
        extraction.validate();

        return extraction;
    }

    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(id)) {
            throw new InvalidExpressionException("execution field must not be empty");
        }

        if (StringUtils.isEmpty(job)) {
            throw new InvalidExpressionException("job field must not be empty");
        }

        process.validate();
    }
}