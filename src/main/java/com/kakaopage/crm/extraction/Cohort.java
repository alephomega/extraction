package com.kakaopage.crm.extraction;

import java.util.List;

public class Cohort {
    private final long total;
    private final List<Partition> partitions;

    public Cohort(List<Partition> partitions) {
        this.total = partitions.stream().mapToLong(Partition::getCount).sum();
        this.partitions = partitions;
    }

    public long getTotal() {
        return total;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public static Cohort with(List<Partition> partitions) {
        return new Cohort(partitions);
    }
}