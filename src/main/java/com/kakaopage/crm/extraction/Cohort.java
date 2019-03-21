package com.kakaopage.crm.extraction;

import java.util.List;

public class Cohort {
    private final String name;
    private final long size;
    private final List<Partition> partitions;

    public Cohort(String name, List<Partition> partitions) {
        this.name = name;
        this.size = partitions.stream().mapToLong(Partition::getCount).sum();
        this.partitions = partitions;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public static Cohort with(String name, List<Partition> partitions) {
        return new Cohort(name, partitions);
    }
}