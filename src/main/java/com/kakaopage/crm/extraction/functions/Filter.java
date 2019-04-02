package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;
import com.kakaopage.crm.extraction.Predicate;
import org.apache.commons.lang3.StringUtils;

@FuncIdentifier("filter")
public class Filter extends ArrayFunction {
    private final Predicate predicate;
    private final String database;
    private final String table;

    public Filter(Value array, Predicate predicate, String database, String table) {
        super(array);
        this.predicate = predicate;
        this.database = database;
        this.table = table;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public String getDatabase() {
        return database;
    }

    public String getTable() {
        return table;
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

        if (StringUtils.isEmpty(database)) {
            throw new InvalidExpressionException("database argument must not be empty");
        }

        if (StringUtils.isEmpty(table)) {
            throw new InvalidExpressionException("table argument must not be empty");
        }

        if (predicate == null) {
            throw new InvalidExpressionException("predicate argument must not be null");
        }

        predicate.validate();
    }
}
