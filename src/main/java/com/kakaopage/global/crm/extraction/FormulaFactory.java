package com.kakaopage.global.crm.extraction;

import com.kakaopage.global.crm.extraction.description.FactoryUtils;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FormulaFactory {

    private static final Map<String, Class<? extends Formula>> classMap = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.kakaopage.global.crm.extraction.formulas");
        Set<Class<? extends Formula>> classes = reflections.getSubTypesOf(Formula.class);

        for (Class<? extends Formula> formulaClass : classes) {
            String symbol = getSymbol(formulaClass);
            if (symbol != null) {
                classMap.put(symbol, formulaClass);
            }
        }
    }

    private static String getSymbol(Class<? extends Formula> formulaClass) {
        Symbol symbol = formulaClass.getAnnotation(Symbol.class);
        if (symbol == null) {
            return null;
        }

        return symbol.value();
    }


    private static Class<? extends Formula> findClass(String name) {
        return classMap.get(name);
    }

    public static Formula formulaOf(String symbol, Map<String, ?> params) {
        return FactoryUtils.create(findClass(symbol), params);
    }
}
