package com.kakaopage.crm.extraction;

import java.util.List;

public interface Operator extends Expression {
    List<?> getOperands();
}
