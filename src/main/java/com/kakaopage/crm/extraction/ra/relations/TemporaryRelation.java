package com.kakaopage.crm.extraction.ra.relations;

import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationType;

@RelationType("temporary")
public class TemporaryRelation extends Relation {

    public TemporaryRelation(String name) {
        super(name);
    }
}
