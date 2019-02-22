package com.kakaopage.global.crm.extraction.formulas;


import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

@Symbol("Days")
public class Days extends Formula {
    private final String event;

    public Days(@Param("event") String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
