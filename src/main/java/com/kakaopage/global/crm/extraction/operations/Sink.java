package com.kakaopage.global.crm.extraction.operations;

import com.kakaopage.global.crm.extraction.DataSink;
import com.kakaopage.global.crm.extraction.Operation;
import com.kakaopage.global.crm.extraction.Operator;

@Operator("Sink")
public abstract class Sink implements Operation {
    private final DataSink dataSink;

    protected Sink(DataSink dataSink) {
        this.dataSink = dataSink;
    }
}
