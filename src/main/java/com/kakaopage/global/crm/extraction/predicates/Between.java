package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("Between")
public class Between<T> extends Predicate<Formula> {
    private final T begin;
    private final T end;

    public Between(@Param("formula") Formula formula, @Param("begin") T begin, @Param("end") T end) {
        super(formula);
        this.begin = begin;
        this.end = end;
    }

    public T begin() {
        return begin;
    }

    public T end() {
        return end;
    }
}