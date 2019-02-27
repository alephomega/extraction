package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.functions.Alias;

import java.util.List;
import java.util.stream.Collectors;

@Symbol("π")
public class Projection extends UnaryRelationalAlgebraOperator {
    private final List<Function> attributes;

    public Projection(List<Alias> attributes, Relation relation) {
        super(relation);
        this.attributes = attributes.stream().collect(Collectors.toList());
    }

    public List<Function> getAttributes() {
        return attributes;
    }
}
