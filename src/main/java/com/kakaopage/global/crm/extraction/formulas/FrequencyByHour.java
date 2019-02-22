package com.kakaopage.global.crm.extraction.formulas;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

import java.util.List;

@Symbol("FrequencyByHour")
public class FrequencyByHour extends Formula {
    private final String event;
    private final List<Integer> hours;

    public FrequencyByHour(@Param("event") String event, @Param("hours") List<Integer> hours) {
        this.event = event;
        this.hours = hours;
    }

    public String getEvent() {
        return event;
    }

    public List<Integer> getHours() {
        return hours;
    }
}
