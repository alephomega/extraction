package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.ra.Aggregation;
import com.kakaopage.crm.extraction.ra.GroupingElement;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GroupBy extends Clause {
    private final List<GroupingElement> groupingElements = new ArrayList<>();
    private final List<Aggregation> aggregations = new ArrayList<>();

    @Override
    public String stringify(StatementContext context) {
        return String.format("group by %s", StringUtils.join(groupingElements.stream().map(element -> ClauseUtils.stringify(element, context)).toArray(), ", "));
    }
}