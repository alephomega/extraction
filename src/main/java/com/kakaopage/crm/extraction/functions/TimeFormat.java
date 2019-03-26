package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("format")
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


    @Override
    public void validate() throws InvalidExpressionException {
        if (time == null) {
            throw new InvalidExpressionException("time argument must not be null");
        }

        time.validate();

        if (StringUtils.isEmpty(pattern)) {
            throw new InvalidExpressionException("pattern argument must not be empty");
        }

        if (StringUtils.isEmpty(timezone)) {
            throw new InvalidExpressionException("timezone argument must not be empty");
        }
    }
}
