package com.kakaopage.crm.extraction;

import java.util.List;

public class Target {
    private final int total;
    private final List<Partition> partitions;

    public Target(List<Partition> partitions) {
        this.total = partitions.stream().mapToInt(Partition::getCount).sum();
        this.partitions = partitions;
    }

    public int getTotal() {
        return total;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public static Target of(List<Partition> partitions) {
        return new Target(partitions);
    }
}