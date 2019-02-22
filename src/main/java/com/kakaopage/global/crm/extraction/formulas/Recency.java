package com.kakaopage.global.crm.extraction.formulas;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

@Symbol("Recency")
public class Recency extends Formula {
    private final String event;
    private final String timezone;

    public Recency(@Param("event") String event, @Param("timezone") String timezone) {
        this.event = event;
        this.timezone = timezone;
    }

    public String getEvent() {
        return event;
    }

    public String getTimezone() {
        return timezone;
    }
}
