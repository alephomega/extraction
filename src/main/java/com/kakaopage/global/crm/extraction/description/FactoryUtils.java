package com.kakaopage.global.crm.extraction.description;

import com.kakaopage.global.crm.extraction.Param;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Map;

public class FactoryUtils {

    public static <T> T create(Class<? extends T> clss, Map<String, ?> params) {
        if (clss == null) {
            return null;
        }

        Constructor[] constructors = clss.getConstructors();
        for (Constructor constructor : constructors) {
            try {
                return (T) constructor.newInstance(args(constructor, params));
            } catch (Exception e) {

            }
        }

        return null;
    }

    private static <T> Object[] args(Constructor<? extends T> constructor, Map<String, ?> params) {
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
