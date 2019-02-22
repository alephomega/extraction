package com.kakaopage.global.crm.extraction.description;

import com.google.gson.annotations.SerializedName;
import com.kakaopage.global.crm.extraction.Predicate;

import java.util.List;

public class Definition {
    private final String variable;

    @SerializedName("suchThat")
    private final List<Predicate> predicates;

    private final String superset;

    public Definition(String variable, List<Predicate> predicates, String superset) {
        this.variable = variable;
        this.predicates = predicates;
        this.superset = superset;
    }

    public String getVariable() {
        return variable;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }

    public String getSuperset() {
        return superset;
    }
}
