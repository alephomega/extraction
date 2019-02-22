package com.kakaopage.global.crm.extraction.formulas;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

@Symbol("Frequency")
public class Frequency extends Formula {
    private final String event;

    public Frequency(@Param("event") String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
