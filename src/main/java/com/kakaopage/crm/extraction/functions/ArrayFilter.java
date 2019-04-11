package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.Predicate;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("array_filter")
public class ArrayFilter extends ArrayFunction {
    private final Predicate predicate;
    private final String relation;

    public ArrayFilter(Value array, Predicate predicate, String relation) {
        super(array);
        this.predicate = predicate;
        this.relation = relation;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public String getRelation() {
        return relation;
    }

    public String getField() {
        return ((Value) getArray()).getAttribute();
    }

    @Override
    public void validate() throws InvalidExpressionException {
        Function array = getArray();
        if (array == null) {
            throw new InvalidExpressionException("array argument must not be null");
        }

        if (!(array instanceof Value)) {
            throw new InvalidExpressionException("array argument must be instance of Value");
        }

        array.validate();

        if (StringUtils.isEmpty(relation)) {
            throw new InvalidExpressionException("source argument must not be empty");
        }

        if (predicate == null) {
            throw new InvalidExpressionException("predicate argument must not be null");
        }

        predicate.validate();
    }

    public static class SchemaDefinition {

    }
}
