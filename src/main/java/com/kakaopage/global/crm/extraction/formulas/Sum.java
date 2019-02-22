package com.kakaopage.global.crm.extraction.formulas;

import com.kakaopage.global.crm.extraction.Formula;
import com.kakaopage.global.crm.extraction.Param;
import com.kakaopage.global.crm.extraction.Symbol;

@Symbol("Sum")
public class Sum extends Formula {
    private final Formula formula;

    public Sum(@Param("formula") Formula formula) {
        this.formula = formula;
    }

    public Formula getFormula() {
        return formula;
    }
}
