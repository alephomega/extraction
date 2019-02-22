package com.kakaopage.global.crm.extraction.operations;

import com.kakaopage.global.crm.extraction.DataSource;
import com.kakaopage.global.crm.extraction.Filter;
import com.kakaopage.global.crm.extraction.Operation;
import com.kakaopage.global.crm.extraction.Operator;

@Operator("Source")
public class Source implements Operation {
    private final String dataSource;
    private final Filter filter;

    public Source(String dataSource, Filter filter) {
        this.dataSource = dataSource;
        this.filter = filter;
    }

    public String getDataSource() {
        return dataSource;
    }

    public Filter getFilter() {
        return filter;
    }
}