package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.ra.GroupingElement;
import com.kakaopage.crm.extraction.ra.Relation;

import java.util.List;
import java.util.stream.Collectors;

public class Select extends Query {

    private boolean distinct = false;
    private List<Column> columns;

    private Relation from;
    private Predicate condition;

    private List<GroupingElement> groupBy;
    private String alias;


    public String toQueryString() {
        QueryContext context = getContext();
        return String.format("select %s from %s where %s", QuerySerializer.serialize(columns, context), QuerySerializer.serialize(from, context), QuerySerializer.serialize(condition, context));
    }


    public void aliasColumn(String name, String alias) {
        Column column = column(name);
        if (column != null) {
            register(alias, new Value(name));
            column.setName(alias);
        }
    }

    private Column column(String name) {
        for (Column column : columns) {
            if (name.equals(column.getName())) {
                return column;
            }
        }

        return null;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        for (Column column : columns) {
            register(column.getName(), column.getFunction());
        }

        this.columns = columns.stream().collect(Collectors.toList());
    }

    private void register(String name, Function function) {
        QueryContext context = getContext();

        if (name != null) {
            if (function instanceof Value) {
                String attribute = ((Value) function).getAttribute();
                if (attribute.equals(name)) {
                    return;
                }
            }

            context.alias(name, function);
        }
    }

    public Relation getFrom() {
        return from;
    }

    public void setFrom(Relation from) {
        this.from = from;
    }

    public Predicate getCondition() {
        return condition;
    }

    public void setCondition(Predicate condition) {
        this.condition = condition;
    }

    public List<GroupingElement> getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(List<GroupingElement> groupBy) {
        this.groupBy = groupBy;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
