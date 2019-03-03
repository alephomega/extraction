package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("≥")
public class GreaterThanOrEqualTo extends ComparativeOperator {

    public GreaterThanOrEqualTo(Function f1, Function f2) {
        super(f1, f2);
    }
}
