package com.kakaopage.crm.extraction;

import java.io.Serializable;

public interface Expression extends Serializable {
    void validate() throws InvalidExpressionException;
}
