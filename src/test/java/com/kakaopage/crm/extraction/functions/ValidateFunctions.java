package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class ValidateFunctions {

    @Test
    public void testConstant() {
        Constant<String> constant = new Constant<>(null);
        try {
            constant.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        constant = new Constant<>("value");
        constant.validate();
    }

    @Test
    public void testValue() {
        Value value = new Value(null, null);
        try {
            value.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        value = new Value(null, "attribute");
        value.validate();

        value = new Value("dataSet", "attribute");
        value.validate();
    }

    @Test
    public void testAlias() {
        Alias alias = new Alias(null, "alias");
        try {
            alias.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        alias = new Alias(new Value(null, "attribute"), null);
        try {
            alias.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        alias = new Alias(new Value(null, "attribute"), "alias");
        alias.validate();
    }

    @Test
    public void testArrayOf() {
        ArrayOf arrayOf = new ArrayOf(null);
        try {
            arrayOf.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        arrayOf = new ArrayOf(new ArrayList<>());
        arrayOf.validate();

        List<Function> array = new ArrayList<>();
        array.add(new Constant<String>("value1"));
        array.add(new Constant<String>(null));

        arrayOf = new ArrayOf(array);
        try {
            arrayOf.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        array.clear();
        array.add(new Constant<String>("value1"));
        array.add(new Constant<String>("value2"));

        arrayOf = new ArrayOf(array);
        arrayOf.validate();
    }

    @Test
    public void testCardinality() {
        Cardinality cardinality = new Cardinality(null);
        try {
            cardinality.validate();
            fail("Expected a InvalidExpressionException to be thrown");
        } catch (InvalidExpressionException ignore) { }

        cardinality = new Cardinality(new Constant<String>("value"));
        cardinality.validate();

        cardinality = new Cardinality(new Value(null, "attribute"));
        cardinality.validate();
    }
}
