package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.relations.RelationalAlgebraOperator;

public interface QueryDecorator<Q extends Query> {
    Q build(Q query, RelationalAlgebraOperator operation);
}
