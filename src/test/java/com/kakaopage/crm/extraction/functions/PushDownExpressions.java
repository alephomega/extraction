package com.kakaopage.crm.extraction.functions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PushDownExpressions {

    @Test
    public void testConstant() {
        Constant<Double> doubleConstant = new Constant<>(1.0);
        assertEquals(doubleConstant.toPushDownExpression(), "1.0");

        Constant<String> stringConstant = new Constant<>("value");
        assertEquals(stringConstant.toPushDownExpression(), "'value'");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Constant<List<Integer>> listConstant = new Constant<>(list);
        assertEquals(listConstant.toPushDownExpression(), "(1, 2)");

        String[] array = new String[2];
        array[0] = "value1";
        array[1] = "value2";
        Constant<String[]> arrayConstant = new Constant<>(array);

        assertEquals(arrayConstant.toPushDownExpression(), "('value1', 'value2')");
    }

    @Test
    public void testValue() {
        Value value = new Value(null, "attribute");
        assertEquals(value.toPushDownExpression(), "attribute");

        value = new Value("dataSet", "attribute");
        assertEquals(value.toPushDownExpression(), "dataSet.attribute");
    }
}
