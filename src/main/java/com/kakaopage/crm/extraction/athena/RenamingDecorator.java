package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Pair;
import com.kakaopage.crm.extraction.ra.Renaming;

import java.util.List;

public class RenamingDecorator implements StatementDecorator<SelectStatement, Renaming> {

    @Override
    public SelectStatement build(SelectStatement statement, Renaming renaming) {
        List<Pair<String, String>> pairs = renaming.getChanges();

        Select select = statement.getSelect();
        for (Pair<String, String> pair : pairs) {
            select.alias(pair.first(), pair.second());
        }

        return statement;
    }
}
