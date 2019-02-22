package com.kakaopage.global.crm.extraction;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class DatasetOperationFactory {

    private static final Map<String, Class<? extends DatasetOperation>> classMap = new HashMap<>();

    static {
        Reflections reflections = new Reflections(DatasetOperationFactory.class.getPackage().getName());
        Set<Class<? extends DatasetOperation>> classes = reflections.getSubTypesOf(DatasetOperation.class);

        for (Class<? extends DatasetOperation> datasetOperationClass : classes) {
            String operator = getOperator(datasetOperationClass);
            if (operator != null) {
                classMap.put(operator, datasetOperationClass);
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


    static DatasetOperation create(String operator, Map<String, ?> params) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends DatasetOperation> datasetOperationClass = classMap.get(operator);
        if (datasetOperationClass == null) {
            return null;
        }

        Constructor[] constructors = datasetOperationClass.getConstructors();
        for (Constructor constructor : constructors) {
            try {
                return (DatasetOperation) constructor.newInstance(args(constructor, params));
            } catch (Exception e) {

            }
        }

        return null;
    }

    private static Object[] args(Constructor<? extends DatasetOperation> constructor, Map<String, ?> params) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Parameter[] parameters = constructor.getParameters();

        Object[] values = new Object[parameters.length];
        for (int i = 0; i < values.length; i++) {
            Param param = findAnnotation(parameters[i], Param.class);
            if (param == null) {
                throw new RuntimeException();
            }

            values[i] = params.get(param.value());
        }

        return values;
    }

    private static <A extends Annotation> A findAnnotation(Parameter parameter, Class<A> annotationClass) {
        return parameter.getAnnotation(annotationClass);
    }
}
