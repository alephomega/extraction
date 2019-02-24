package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;

public class Filter implements ArrayFunction {
    private final Function array;
    private final Predicate condition;

    public Filter(Function array, Predicate condition) {
        this.array = array;
        this.condition = condition;
    }
}
