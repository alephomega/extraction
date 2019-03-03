package com.kakaopage.crm.extraction.ra;


public class ColumnOrdering {
    private final String column;
    private final OrderBy orderBy;

    public ColumnOrdering(String column, OrderBy orderBy) {
        this.column = column;
        this.orderBy = orderBy;
    }

    public String getColumn() {
        return column;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }
}