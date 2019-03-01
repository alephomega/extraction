package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;

public interface StatementDecorator<S extends Statement, T extends RelationalAlgebraOperator> {
    S build(S statement, T operation);
}
