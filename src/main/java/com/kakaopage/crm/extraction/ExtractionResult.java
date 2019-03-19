package com.kakaopage.crm.extraction;

public class ExtractionResult {
    private final Cohort cohort;

    public ExtractionResult(Cohort cohort) {
        this.cohort = cohort;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public static ExtractionResult with(Cohort cohort) {
        return new ExtractionResult(cohort);
    }
}
