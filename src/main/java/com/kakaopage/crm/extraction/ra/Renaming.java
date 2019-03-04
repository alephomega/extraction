package com.kakaopage.crm.extraction.ra;

import com.kakaopage.crm.extraction.Pair;
import com.kakaopage.crm.extraction.Symbol;

import java.util.List;

@Symbol("ρ")
public class Renaming extends UnaryRelationalAlgebraOperator {
    private final List<Pair<String, String>> changes;

    public Renaming(List<Pair<String, String>> changes, Relation relation) {
        super(relation);
        this.changes = changes;
    }

    public List<Pair<String, String>> getChanges() {
        return changes;
    }

    public static String from(Pair<String, String> change) {
        return change.first();
    }

    public static String to(Pair<String, String> change) {
        return change.second();
    }
}
