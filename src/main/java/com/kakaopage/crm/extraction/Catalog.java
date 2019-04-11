package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.relations.Source;

public class Catalog {

    public static String database(Source source) {
        return ApplicationProperties.get("glue.database", null);
    }

    public static String table(Source source) {
        return source.getName();
    }
}