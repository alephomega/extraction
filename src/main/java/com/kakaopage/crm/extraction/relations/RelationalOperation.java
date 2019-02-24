package com.kakaopage.crm.extraction.relations;

import com.kakaopage.crm.extraction.Operation;

import java.util.List;

public interface RelationalOperation extends Operation {
    public Relation[] inputs();
}
