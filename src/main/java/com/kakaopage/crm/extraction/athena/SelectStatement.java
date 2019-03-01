package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Value;

public class SelectStatement extends Statement {

    private boolean distinct = false;
    private Select select;
    private From from;
    private Where where;
    private GroupBy groupBy;
    private As as;


    public String toString() {
        StatementContext context = getContext();
        return String.format("%s %s %s %s", select, from, where, groupBy);
    }

    private void register(String name, Function function) {
        StatementContext context = getContext();

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

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Where getWhere() {
        return where;
    }

    public void setWhere(Where where) {
        this.where = where;
    }

    public GroupBy getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(GroupBy groupBy) {
        this.groupBy = groupBy;
    }

    public As getAs() {
        return as;
    }

    public void setAs(As as) {
        this.as = as;
    }
}
