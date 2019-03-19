package com.kakaopage.crm.extraction;

public class Partition {
    private final int id;
    private final String path;
    private final long count;

    public Partition(int id, String path, long count) {
        this.id = id;
        this.path = path;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public long getCount() {
        return count;
    }

    public String getPath() {
        return path;
    }

    public static Partition of(int id, String path, long count) {
        return new Partition(id, path, count);
    }
}