package com.kakaopage.crm.extraction;

import java.util.List;
import java.util.stream.Collectors;

public class Target {
    private final String job;
    private final String execution;
    private final String key;
    private final boolean repeated;
    private List<Split> splits;

    private Target(String job, String execution, String key, boolean repeated, List<Split> splits) {
        this.job = job;
        this.execution = execution;
        this.key = key;
        this.repeated = repeated;
        this.splits = splits;
    }

    public String getJob() {
        return job;
    }

    public String getExecution() {
        return execution;
    }

    public String getKey() {
        return key;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public static Target with(String job, String execution, ExtractionResult result) {
        Cohort cohort = result.getCohort();
        List<Split> splits = cohort.getPartitions().stream().map(partition -> new Split(partition.getPath(), partition.getCount())).collect(Collectors.toList());

        return new Target(job, execution, cohort.getName(), cohort.isRepeated(), splits);
    }
}