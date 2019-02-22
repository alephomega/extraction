package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("In")
public class In<T> extends Predicate<Formula> {

    protected In(Formula value) {
        super(value);
    }
}
