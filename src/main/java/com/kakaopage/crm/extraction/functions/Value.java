package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.PushDown;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("value")
public class Value implements Function, PushDown {
    private final String dataSet;
    private final String attribute;

    public Value(String dataSet, String attribute) {
        this.dataSet = dataSet;
        this.attribute = attribute;
    }

    public String getDataSet() {
        return dataSet;
    }

    public String getAttribute() {
        return attribute;
    }

    @Override
    public String toPushDownExpression() {
        if (StringUtils.isEmpty(dataSet)) {
            return attribute;
        }

        return String.format("%s.%s", dataSet, attribute);
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (StringUtils.isEmpty(attribute)) {
            throw new InvalidExpressionException("attribute argument must not be empty");
        }
    }
}