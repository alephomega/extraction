package com.kakaopage.crm.extraction.predicates;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;

@Symbol("≤")
public class LessThanOrEqualTo extends ComparativeOperator {

    public LessThanOrEqualTo(Function f1, Function f2) {
        super(f1, f2);
    }
}
