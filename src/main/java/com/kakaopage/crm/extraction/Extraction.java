package com.kakaopage.crm.extraction;

import java.util.List;

public class Extraction {
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
}
