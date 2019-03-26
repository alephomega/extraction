package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.PushDown;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;

@FuncIdentifier("const")
public class Constant<T> implements Function, PushDown {

    private final T value;

    public Constant(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toPushDownExpression() {
        if (value == null) {
            return StringUtils.EMPTY;
        }

        String separator = ", ";
        if (value instanceof Collection<?>) {
            Object[] args = ((Collection<?>) value).stream().map(this::valueExpression).toArray();
            return String.format("(%s)", StringUtils.join(args, separator));
        }

        Class<?> valueClass = value.getClass();
        if (valueClass.isArray()) {
            int length = Array.getLength(value);

            String[] args = new String[length];
            for (int i = 0; i < length; i++) {
                args[i] = valueExpression(Array.get(value, i));
            }

            return String.format("(%s)", StringUtils.join(args, separator));
        }

        return valueExpression(value);
    }

    private String valueExpression(Object obj) {
        if (obj instanceof String || obj instanceof Character) {
            return String.format("'%s'", obj);
        }

        return String.format("%s", String.valueOf(obj));
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (value == null) {
            throw new InvalidExpressionException("value argument must not be null");
        }
    }
}
