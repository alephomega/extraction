package com.kakaopage.global.crm.extraction.description;


import java.util.Map;

public class Value {
    private final String formula;
    private final Map params;

    public Value(String formula, Map params) {
        this.formula = formula;
        this.params = params;
    }

    public String getFormula() {
        return formula;
    }

    public Object getParam(String name) {
        return params.get(name);
    }

    public Map getParams() {
        return params;
    }
}
