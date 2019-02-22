package com.kakaopage.global.crm.extraction.formulas;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

@Symbol("FrequencyByDay")
public class FrequencyByDay extends Formula {
    private final String event;
    private final int[] days;

    public FrequencyByDay(@Param("event") String event, @Param("days") int[] days) {
        this.event = event;
        this.days = days;
    }

    public String getEvent() {
        return event;
    }

    public int[] getDays() {
        return days;
    }
}
