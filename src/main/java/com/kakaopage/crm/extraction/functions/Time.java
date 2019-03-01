package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;

public class Time implements Function {
    private final Function text;
    private final String pattern;
    private final String timezone;

    public Time(Function text, String pattern, String timezone) {
        this.text = text;
        this.pattern = pattern;
        this.timezone = timezone;
    }

    public Function getText() {
        return text;
    }

    public String getPattern() {
        return pattern;
    }

    public String getTimezone() {
        return timezone;
    }
}
