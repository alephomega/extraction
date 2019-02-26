package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("≤")
class LessThanOrEqualTo extends ComparativeOperator {

    LessThanOrEqualTo(Function f1, Function f2) {
        super(f1, f2);
    }
}
