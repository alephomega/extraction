package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Symbol;
import com.kakaopage.crm.extraction.Pair;

import java.util.List;

@Symbol("ρ")
public class Renaming extends UnaryRelationalAlgebraOperator {
    private final List<Pair<String, String>> renamings;

    Renaming(List<Pair<String, String>> renamings, Relation relation) {
        super(relation);
        this.renamings = renamings;
    }

    public List<Pair<String, String>> getRenamings() {
        return renamings;
    }
}
