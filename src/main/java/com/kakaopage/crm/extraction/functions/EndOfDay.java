package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("end_of_day")
public class EndOfDay implements Function {
    private final Function time;
    private final String timezone;

    public EndOfDay(Function time, String timezone) {
        this.time = time;
        this.timezone = timezone;
    }

    public Function getTime() {
        return time;
    }

    public String getTimezone() {
        return timezone;
    }
}
