package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;
import com.kakaopage.crm.extraction.functions.Constant;
import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.predicates.Conjunction;
import com.kakaopage.crm.extraction.predicates.Equals;
import com.kakaopage.crm.extraction.predicates.IsIn;
import com.kakaopage.crm.extraction.ra.Relation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class QuerySerializer {

    static String serialize(List<SelectExpression> selectExpressions, StatementContext context) {
        return StringUtils.join(selectExpressions.stream().map(column -> serialize(column, context)).toArray(), ", ");
    }

    static String serialize(SelectExpression selectExpression, StatementContext context) {
        return String.format("%s as %s", serialize(selectExpression.getFunction(), context), selectExpression.getName());
    }


    static String serialize(Function function, StatementContext context) {
        if (function instanceof Value) {
            String attribute = ((Value) function).getAttribute();
            NamingContext namingContext = context.getNamingContext();
            Function nestedFunction = namingContext.get(attribute);

            if (nestedFunction != null) {
                return serialize(nestedFunction, context);
            }

            return ((Value) function).getAttribute();
        }

        if (function instanceof Constant) {
            return serialize(((Constant) function).getValue(), context);
        }


        return "";
    }

    static String serialize(Predicate condition, StatementContext context) {
        if (condition instanceof Conjunction) {
            List<Predicate> predicates = ((Conjunction) condition).getPredicates();
            return String.format("(%s)", StringUtils.join(predicates.stream().map(predicate -> serialize(predicate, context)).toArray(), " and "));
        }

        if (condition instanceof Equals) {
            Equals equals = (Equals) condition;
            return String.format("%s = %s", serialize(equals.firstOperand(), context), serialize(equals.secondOperand(), context));
        }

        if (condition instanceof IsIn) {
            IsIn in = (IsIn) condition;
            List elements = in.getElements();
            return String.format("%s in [%s]", serialize(in.getValue(), context), StringUtils.join(elements.stream().map(element -> serialize(element, context)).toArray(), ", "));
        }

        return "";
    }

    static String serialize(Conjunction conjunction, StatementContext context) {
        List<Predicate> predicates = conjunction.getPredicates();
        return String.format("(%s)", StringUtils.join(predicates.stream().map(predicate -> serialize(predicate, context)).toArray(), " and "));
    }

    private static String serialize(Object value, StatementContext context) {
        if (value instanceof String) {
            return String.format("'%s'", value);
        }

        Class<?> clss = value.getClass();
        return value.toString();
    }

    static String serialize(Relation relation, StatementContext context) {
        return relation.getName();
    }
}