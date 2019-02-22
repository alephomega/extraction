package com.kakaopage.global.crm.extraction.operations;

import com.kakaopage.global.crm.extraction.DatasetOperation;
import com.kakaopage.global.crm.extraction.Operator;

@Operator("Partitioning")
public class Partitioning extends DatasetOperation {

    private final PartitioningStrategy partitioningStrategy;
    private final int partitions;

    public Partitioning(PartitioningStrategy partitioningStrategy, int partitions) {
        this.partitioningStrategy = partitioningStrategy;
        this.partitions = partitions;
    }

    public PartitioningStrategy getPartitioningStrategy() {
        return partitioningStrategy;
    }


    public static class PartitioningStrategy {

    }
}