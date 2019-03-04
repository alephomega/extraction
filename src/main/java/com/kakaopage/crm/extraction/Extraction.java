package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Extraction {
    private final static Gson GSON =  new GsonBuilder().registerTypeAdapter(Function.class, new FunctionJsonDeserializer())
            .registerTypeAdapter(Predicate.class, new PredicateJsonDeserializer())
            .registerTypeAdapter(Assignment.class, new AssignmentJsonDeserializer())
            .create();

    private final List<Assignment> expressions;
    private final Sink sink;

    public Extraction(List<Assignment> expressions, Sink sink) {
        this.expressions = expressions;
        this.sink = sink;
    }

    public List<Assignment> getExpressions() {
        return expressions;
    }

    public Sink getSink() {
        return sink;
    }

    public static Extraction of(String description) {
        return GSON.fromJson(description, Extraction.class);
    }
}
