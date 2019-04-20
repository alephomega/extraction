package com.kakaopage.crm.extraction;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Cohort {
    private final String name;
    private final int interval;
    private final long size;
    private final List<Partition> partitions;

    public Cohort(String name, int interval, List<Partition> partitions) {
        this.name = name;
        this.interval = interval;
        this.size = partitions.stream().mapToLong(Partition::getCount).sum();
        this.partitions = partitions;
    }

    public String getName() {
        return name;
    }

    public int getInterval() {
        return interval;
    }

    public long getSize() {
        return size;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public static Cohort with(String name, int interval, List<Partition> partitions) {
        return new Cohort(name, interval, partitions);
    }

    @Override
    public String toString() {
        return String.format("{ name: %s, interval: %d, partitions: [ %s ]  }", name, interval, StringUtils.join(partitions, ", "));
    }
}