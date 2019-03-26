package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("start_of_day")
public class StartOfDay implements Function {
    private final Function time;
    private final String timezone;

    public StartOfDay(Function time, String timezone) {
        this.time = time;
        this.timezone = timezone;
    }

    public Function getTime() {
        return time;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (time == null) {
            throw new InvalidExpressionException("time argument must not be null");
        }

        time.validate();

        if (StringUtils.isEmpty(timezone)) {
            throw new InvalidExpressionException("timezone argument must not be empty");
        }
    }
}