package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("time_add")
public class TimeAdd implements Function {
    private final Function time;
    private final String unit;
    private final int amount;
    private final String timezone;

    public TimeAdd(Function time, String unit, int amount, String timezone) {
        this.time = time;
        this.unit = unit;
        this.amount = amount;
        this.timezone = timezone;
    }

    public Function getTime() {
        return time;
    }

    public String getUnit() {
        return unit;
    }

    public int getAmount() {
        return amount;
    }

    public String getTimezone() {
        return timezone;
    }
}