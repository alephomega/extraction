package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.ra.relations.Source;
import org.apache.commons.lang3.StringUtils;

public class Catalog {

    public static String database(Source source) {
        return ApplicationProperties.get(
                String.format("%s@%s.database", source.getName(), source.getGroup()), null);
    }

    public static String table(Source source) {
        return ApplicationProperties.get(
                String.format("%s@%s.table", source.getName(), source.getGroup()), null);
    }

    public static String pushDown(Source source) {
        Predicate predicate = source.getPushDown();
        return predicate == null ? StringUtils.EMPTY : predicate.toPushDownExpression();
    }
}