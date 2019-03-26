package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

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

    @Override
    public void validate() throws InvalidExpressionException {
        if (time == null) {
            throw new InvalidExpressionException("time argument must not be null");
        }

        time.validate();

        validateUnit();

        if (StringUtils.isEmpty(timezone)) {
            throw new InvalidExpressionException("timezone argument must not be empty");
        }
    }

    private void validateUnit() {
        if (StringUtils.isEmpty(unit)) {
            throw new InvalidExpressionException("unit argument must not be empty");
        }

        switch (unit) {
            case "days":
            case "hours":
            case "minutes":
            case "seconds":
            case "milliseconds":
                break;

            default:
                throw new InvalidExpressionException("unit argument is invalid");
        }
    }
}