package com.kakaopage.crm.extraction.relations;


import com.kakaopage.crm.extraction.Operator;

import java.util.List;

@Operator("⨯")
public class Product implements RelationalOperation {
    private List<Relation> relations;

    @Override
    public Relation[] inputs() {
        return relations.toArray(new Relation[0]);
    }
}
