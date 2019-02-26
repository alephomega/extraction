package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;

@Symbol(">")
class GreaterThan extends ComparativeOperator {

    GreaterThan(Function f1, Function f2) {
        super(f1, f2);
    }
}
