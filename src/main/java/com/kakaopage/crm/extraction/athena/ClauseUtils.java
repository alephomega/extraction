package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.functions.Constant;
import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.ra.GroupingElement;

public class ClauseUtils {

    public static String stringify(Function function, StatementContext context) {

        if (function instanceof Value) {
            String attribute = ((Value) function).getAttribute();
            NamingContext namingContext = context.getNamingContext();
            Function nestedFunc = namingContext.get(attribute);

            if (nestedFunc != null) {
                return stringify(nestedFunc, context);
            }

            return ((Value) function).getAttribute();
        }

        if (function instanceof Constant) {
            return stringify(((Constant) function).getValue(), context);
        }

        return null;
    }

    public static String stringify(GroupingElement groupingElement, StatementContext context) {
        return stringify(groupingElement.getBy(), context);
    }

    public static String stringify(Object value, StatementContext context) {
        if (value instanceof String) {
            return String.format("'%s'", value);
        }

        Class<?> clss = value.getClass();
        return value.toString();

    }
}
