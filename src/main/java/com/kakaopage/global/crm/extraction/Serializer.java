package com.kakaopage.global.crm.extraction;

import com.kakaopage.global.crm.extraction.description.Definition;
import com.kakaopage.global.crm.extraction.description.Extraction;
import com.kakaopage.global.crm.extraction.description.Transformation;
import com.kakaopage.global.crm.extraction.description.Value;

import java.util.ArrayList;
import java.util.List;

public class Serializer {

    public static List<Step> serialize(Extraction extraction) {
        List<Step> steps = new ArrayList<>();

        List<Definition> definitions = extraction.getDefinitions();
        Transformation transformation = extraction.getTransformation();

        return null;
    }

//    public static Step toStep(Definition definition) throws IllegalAccessException, InstantiationException, InvocationTargetException {
//        List<Predicate> predicates = new ArrayList<>();
//
//        for (SuchThat suchThat : definition.getPredicates()) {
//            predicates.add(toPredicate(suchThat));
//        }
//
//        return new Step(stepName(), new Step[0], new Source(definition.getSuperset(), new Filter(predicates)));
//    }
//
//    public static Step toStep(Transformation transformation) throws IllegalAccessException, InstantiationException, InvocationTargetException {
//        String operator = transformation.getOperator();
//        DatasetOperation datasetOperation = DatasetOperationFactory.create(operator, transformation.getParams());
//
//        return new Step(stepName(), new Step[0], datasetOperation);
//    }
//
//    private static Predicate toPredicate(SuchThat suchThat) throws IllegalAccessException, InvocationTargetException, InstantiationException {
//        String operator = suchThat.getOperator();
//        Map params = suchThat.getParams();
//
//        return PredicateFactory.create(operator, params);
//    }

    private static Formula toFormula(Value value) {
        return null;
    }

    private static String stepName() {
        return null;
    }

    private static Definition find(List<Definition> definitions, String variable) {
        for (Definition definition : definitions) {
            if (definition.getVariable().equals(variable)) {
                return definition;
            }
        }

        return null;
    }
}