package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Pair;
import com.kakaopage.crm.extraction.relations.RelationalAlgebraOperator;
import com.kakaopage.crm.extraction.relations.Renaming;

import java.util.List;

public class RenamingDecorator implements QueryDecorator<Select> {

    @Override
    public Select build(Select select, RelationalAlgebraOperator operation) {
        if (!Renaming.class.isAssignableFrom(operation.getClass())) {
            return select;
        }

        Renaming renaming = (Renaming) operation;
        List<Pair<String, String>> pairs = renaming.getRenamings();
        for (Pair<String, String> pair : pairs) {
            select.setColumnAlias(pair.getFirst(), pair.getSecond());
        }

        return select;
    }
}
