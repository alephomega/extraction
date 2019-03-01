package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

public class TimeFormat implements Function {
    private final Function time;
    private final String pattern;
    private final String timezone;

    public TimeFormat(Function time, String pattern, String timezone) {
        this.time = time;
        this.pattern = pattern;
        this.timezone = timezone;
    }

    public Function getTime() {
        return time;
    }

    public String getPattern() {
        return pattern;
    }

    public String getTimezone() {
        return timezone;
    }


}
