package com.kakaopage.global.crm.extraction.formulas;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

@Symbol("Time")
public class Time extends Formula {
    private final String timezone;

    public Time(@Param("timezone") String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone() {
        return timezone;
    }
}
