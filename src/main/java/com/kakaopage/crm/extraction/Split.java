package com.kakaopage.crm.extraction;

public class Split {
    private final String path;
    private final long size;

    public Split(String path, long size) {
        this.path = path;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }
}
