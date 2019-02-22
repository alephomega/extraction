package com.kakaopage.global.crm.extraction.predicates;

import com.kakaopage.global.crm.extraction.Operator;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Predicate;

@Operator("All")
public class All extends Predicate<Predicate[]> {

    public All(@Param("predicates") Predicate[] predicates) {
        super(predicates);
    }
}
