package com.kakaopage.global.crm.extraction;

import com.kakaopage.global.crm.extraction.description.FactoryUtils;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PredicateFactory {

    private static final Map<String, Class<? extends Predicate>> classMap = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.kakaopage.global.crm.extraction.predicates");
        Set<Class<? extends Predicate>> classes = reflections.getSubTypesOf(Predicate.class);

        for (Class<? extends Predicate> predicateClass : classes) {
            String operator = getOperator(predicateClass);
            if (operator != null) {
                classMap.put(operator, predicateClass);
            }
        }
    }

    private static String getOperator(Class<? extends Operation> operationClass) {
        Operator operator = operationClass.getAnnotation(Operator.class);
        if (operator == null) {
            return null;
        }

        return operator.value();
    }

    private static Class<? extends Predicate> findClass(String name) {
        return classMap.get(name);
    }

    public static Predicate predicateOf(String operator, Map<String, ?> params) {
        return FactoryUtils.create(findClass(operator), params);
    }
}
