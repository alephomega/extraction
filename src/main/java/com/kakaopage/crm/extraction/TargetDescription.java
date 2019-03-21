package com.kakaopage.crm.extraction;

import java.util.List;
import java.util.stream.Collectors;

public class TargetDescription {
    private final String job;
    private final String execution;
    private final String key;
    private List<Split> splits;

    private TargetDescription(String job, String execution, String key, List<Split> splits) {
        this.job = job;
        this.execution = execution;
        this.key = key;
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

    public List<Split> getSplits() {
        return splits;
    }

    public static TargetDescription with(String job, String execution, ExtractionResult result) {
        Cohort cohort = result.getCohort();
        List<Split> splits = cohort.getPartitions().stream().map(partition -> new Split(partition.getPath(), partition.getCount())).collect(Collectors.toList());

        return new TargetDescription(job, execution, cohort.getName(), splits);
    }
}