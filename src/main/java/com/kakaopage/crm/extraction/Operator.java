package com.kakaopage.crm.extraction;

import java.util.List;

public interface Operator extends Description {
    List<?> getOperands();
}
