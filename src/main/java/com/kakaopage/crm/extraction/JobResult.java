package com.kakaopage.crm.extraction;

public class JobResult {
    private final Target target;

    public JobResult(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return target;
    }

    public static JobResult of(Target target) {
        return new JobResult(target);
    }
}
