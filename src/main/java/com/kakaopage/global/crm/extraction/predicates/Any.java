package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("Any")
public class Any extends Predicate<Predicate[]> {
    public Any(@Param("predicates") Predicate[] predicates) {
        super(predicates);
    }
}
