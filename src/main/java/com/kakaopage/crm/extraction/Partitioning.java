package com.kakaopage.crm.extraction;

import java.util.List;

public class Partitioning {
    private final int numPartitions;
    private final List<Function> columns;

    public Partitioning(int numPartitions, List<Function> columns) {
        this.numPartitions = numPartitions;
        this.columns = columns;
    }

    public int getNumPartitions() {
        return numPartitions;
    }

    public List<Function> getColumns() {
        return columns;
    }
}
