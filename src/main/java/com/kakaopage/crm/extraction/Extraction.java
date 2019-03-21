package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Extraction {
    private final static Gson GSON =  new GsonBuilder().registerTypeAdapter(Function.class, new FunctionJsonDeserializer())
            .registerTypeAdapter(Predicate.class, new PredicateJsonDeserializer())
            .registerTypeAdapter(Assignment.class, new AssignmentJsonDeserializer())
            .create();

    private final String job;
    private final String execution;
    private final ProcessDescription description;

    public Extraction(String job, String execution, ProcessDescription description) {
        this.job = job;
        this.execution = execution;
        this.description = description;
    }

    public String getJob() {
        return job;
    }

    public String getExecution() {
        return execution;
    }

    public ProcessDescription getDescription() {
        return description;
    }

    public static Extraction of(String description) {
        return GSON.fromJson(description, Extraction.class);
    }
}