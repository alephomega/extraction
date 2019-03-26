package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("diff")
public class DiffTime implements Function {
    private final Function _1;
    private final Function _2;
    private final String unit;

    public DiffTime(Function _1, Function _2, String unit) {
        this._1 = _1;
        this._2 = _2;

        this.unit = unit;
    }

    public Function firstTime() {
        return _1;
    }

    public Function secondTime() {
        return _2;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (_1 == null) {
            throw new InvalidExpressionException("_1 argument must not be null");
        }

        if (_2 == null) {
            throw new InvalidExpressionException("_2 argument must not be null");
        }

        _1.validate();
        _2.validate();

        validateUnit();
    }

    private void validateUnit() throws InvalidExpressionException {
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
