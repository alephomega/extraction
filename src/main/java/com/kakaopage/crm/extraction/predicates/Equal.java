package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Operator;

@Operator("=")
class Equal extends ComparativeOperation {

    Equal(Function f1, Function f2) {
        super(f1, f2);
    }
}
