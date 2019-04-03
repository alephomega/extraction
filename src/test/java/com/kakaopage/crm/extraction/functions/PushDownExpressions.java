package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.predicates.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PushDownExpressions {

    @Test
    public void testConstant() {
        Constant<Double> doubleConstant = new Constant<>(1.0);
        assertEquals(doubleConstant.toPushDownExpression(), "1.0");

        Constant<String> stringConstant = new Constant<>("a");
        assertEquals(stringConstant.toPushDownExpression(), "'a'");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Constant<List<Integer>> listConstant = new Constant<>(list);
        assertEquals(listConstant.toPushDownExpression(), "(1, 2)");

        String[] array = new String[2];
        array[0] = "a";
        array[1] = "b";
        Constant<String[]> arrayConstant = new Constant<>(array);

        assertEquals("('a', 'b')", arrayConstant.toPushDownExpression());
    }

    @Test
    public void testValue() {
        Value value = new Value(null, "a");
        assertEquals("a", value.toPushDownExpression());

        value = new Value("ds", "a");
        assertEquals("ds.a", value.toPushDownExpression());
    }

    @Test
    public void testBetween() {
        Between between = new Between(new Value("ds", "a"), new Constant<>("from"), new Constant<>("to"));
        assertEquals("ds.a between 'from' and 'to'", between.toPushDownExpression());
    }

    @Test
    public void testEquals() {
        Equals equals = new Equals(new Value("ds", "a"), new Constant<>(1.5));
        assertEquals("ds.a = 1.5", equals.toPushDownExpression());

        equals = new Equals(new Value("ds", "a"), new Constant<>("a"));
        assertEquals("ds.a = 'a'", equals.toPushDownExpression());
    }

    @Test
    public void testGreaterThan() {
        GreaterThan greaterThan = new GreaterThan(new Value("ds", "a"), new Constant<>(10));
        assertEquals("ds.a > 10", greaterThan.toPushDownExpression());
    }

    @Test
    public void testGreaterThanOrEqualTo() {
        GreaterThanOrEqualTo greaterThanOrEqualTo = new GreaterThanOrEqualTo(new Value("ds", "a"), new Constant<>("2019-01-01"));
        assertEquals("ds.a >= '2019-01-01'", greaterThanOrEqualTo.toPushDownExpression());
    }

    @Test
    public void testLessThan() {
        LessThan lessThan = new LessThan(new Value("ds", "a"), new Constant<>(10));
        assertEquals("ds.a < 10", lessThan.toPushDownExpression());
    }

    @Test
    public void testLessThanOrEqualTo() {
        LessThanOrEqualTo lessThanOrEqualTo = new LessThanOrEqualTo(new Value("ds", "a"), new Constant<>("2019-01-01"));
        assertEquals("ds.a <= '2019-01-01'", lessThanOrEqualTo.toPushDownExpression());
    }

    @Test
    public void testIsIn() {
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            elements.add(i);
        }

        IsIn<Integer> isIn = new IsIn<>(new Value("ds", "a"), new Constant<>(elements));
        assertEquals("ds.a in (0, 1, 2, 3, 4)", isIn.toPushDownExpression());
    }

    @Test
    public void testTrue() {
        assertEquals("1 = 1", new True().toPushDownExpression());
    }

    @Test
    public void testIgnorable() {
        Ignorable ignorable = new Ignorable(new Equals(new Value("ds", "a"), new Constant<>("a")), true);
        assertEquals("1 = 1", ignorable.toPushDownExpression());

        ignorable = new Ignorable(new Equals(new Value("ds", "a"), new Constant<>("a")), false);
        assertEquals("ds.a = 'a'", ignorable.toPushDownExpression());
    }

    @Test
    public void testNegation() {
        Negation negation = new Negation(new Equals(new Value("ds", "a"), new Constant<>("a")));
        assertEquals("not(ds.a = 'a')", negation.toPushDownExpression());
    }

    @Test
    public void testConjunction() {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(new GreaterThanOrEqualTo(new Value("ds", "a1"), new Constant<>("2019-01-01")));
        predicates.add(new Equals(new Value("ds", "a2"), new Constant<>("a")));
        predicates.add(new True());

        Conjunction conjunction = new Conjunction(predicates);
        assertEquals("(ds.a1 >= '2019-01-01' and ds.a2 = 'a' and 1 = 1)", conjunction.toPushDownExpression());
    }

    @Test
    public void testDisjunction() {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(new GreaterThanOrEqualTo(new Value("ds", "a1"), new Constant<>("2019-01-01")));
        predicates.add(new Equals(new Value("ds", "a2"), new Constant<>("a")));
        predicates.add(new True());

        Disjunction disjunction = new Disjunction(predicates);
        assertEquals("(ds.a1 >= '2019-01-01' or ds.a2 = 'a' or 1 = 1)", disjunction.toPushDownExpression());
    }

    @Test
    public void test() {
        List<Predicate> p1 = new ArrayList<>();
        p1.add(new GreaterThanOrEqualTo(new Value("ds", "a1"), new Constant<>("2019-01-01")));
        p1.add(new Equals(new Value("ds", "a2"), new Constant<>("a")));

        Conjunction c1 = new Conjunction(p1);

        List<Predicate> p2 = new ArrayList<>();
        p2.add(new LessThan(new Value("ds", "a3"), new Constant<>("2019-02-01")));
        p2.add(new Negation(new Equals(new Value("ds", "a4"), new Constant<>(1))));

        Disjunction d1 = new Disjunction(p2);

        List<Predicate> p3 = new ArrayList<>();
        p3.add(c1);
        p3.add(d1);

        Conjunction c2 = new Conjunction(p3);
        assertEquals("((ds.a1 >= '2019-01-01' and ds.a2 = 'a') and (ds.a3 < '2019-02-01' or not(ds.a4 = 1)))", c2.toPushDownExpression());
    }
}
