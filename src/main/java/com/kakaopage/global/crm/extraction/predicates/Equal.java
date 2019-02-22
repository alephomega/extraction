package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("Equal")
public class Equal<T> extends Predicate<Formula> {

    protected Equal(@Param("formula") Formula formula, @Param("to") T to) {
        super(formula);
    }
}