package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("Less")
public class Less<T> extends Predicate<Formula> {
    private final T than;
    private final boolean orEqualTo;


    public Less(@Param("formula") Formula formula, @Param("than") T than, @Param("orEqualTo") boolean orEqualTo) {
        super(formula);
        this.than = than;
        this.orEqualTo = orEqualTo;
    }

    public T getThan() {
        return than;
    }

    public boolean isOrEqualTo() {
        return orEqualTo;
    }
}
