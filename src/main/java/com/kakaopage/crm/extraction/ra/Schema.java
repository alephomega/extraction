package com.kakaopage.crm.extraction.ra;

import java.util.List;

public class Schema {
    private final List<Attribute> attributes;

    public Schema(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public static class Attribute {
        private final String name;
        private final DataType type;

        public Attribute(String name, DataType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public DataType getType() {
            return type;
        }
    }
}
