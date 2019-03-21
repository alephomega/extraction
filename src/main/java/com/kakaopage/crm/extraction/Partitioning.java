package com.kakaopage.crm.extraction;

import java.util.List;

public class Partitioning {
    private final int partitions;
    private final List<Function> columns;

    public Partitioning(int partitions, List<Function> columns) {
        this.partitions = partitions;
        this.columns = columns;
    }

    public int getPartitions() {
        return partitions;
    }

    public List<Function> getColumns() {
        return columns;
    }
}
