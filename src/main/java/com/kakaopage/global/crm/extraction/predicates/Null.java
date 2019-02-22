package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("Null")
public class Null extends Predicate<Formula> {

    protected Null(@Param("formula") Formula formula) {
        super(formula);
    }
}
