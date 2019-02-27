package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;

public interface QueryDecorator<Q extends Query> {
    Q build(Q query, RelationalAlgebraOperator operation);
}
