package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.relations.GroupingElement;
import com.kakaopage.crm.extraction.relations.Relation;

import java.util.List;

class Select extends Query {

    private boolean distinct = false;
    private List<Column> columns;

    private Relation from;
    private Predicate condition;

    private List<GroupingElement> groupBy;
    private String alias;


    public void setColumnAlias(String name, String alias) {
        Column column = findColumn(name);
        if (column != null) {
            column.setAlias(alias);
        }
    }

    private Column findColumn(String name) {
        for (Column column : columns) {
            if (name.equals(getName(column))) {
                return column;
            }
        }

        return null;
    }

    private String getName(Column column) {
        String alias = column.getAlias();
        if (alias != null) {
            return alias;
        }

        Function function = column.getFunction();
        if (function instanceof Value) {
            return ((Value) function).getAttribute();
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
        this.columns = columns;
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
