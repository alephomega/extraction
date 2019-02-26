package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Predicate;

@FuncIdentifier("filter")
public class Filter extends ArrayFunction {

    private final Predicate predicate;

    public Filter(Function array, Predicate predicate) {
        super(array);
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
