package com.kakaopage.crm.extraction;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

public class Target {

    @SerializedName("job_id")
    private final String job;

    @SerializedName("job_execution_id")
    private final String execution;

    @SerializedName("split_name")
    private final String key;

    @SerializedName("split")
    private List<Split> splits;

    private Target(String job, String execution, String key, List<Split> splits) {
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

    public static Target with(String job, String execution, Cohort cohort) {
        List<Split> splits = cohort.getPartitions().stream().map(partition -> new Split(partition.getPath(), partition.getCount())).collect(Collectors.toList());
        return new Target(job, execution, cohort.getName(), splits);
    }
}