package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;

@FuncIdentifier("elementAt")
public class ElementAt extends ArrayFunction {

    private final int index;

    public ElementAt(Function array, int index) {
        super(array);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
