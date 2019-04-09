package com.kakaopage.crm.extraction.functions;

import com.kakaopage.crm.extraction.FuncIdentifier;
import com.kakaopage.crm.extraction.Function;
import com.kakaopage.crm.extraction.InvalidExpressionException;

import java.util.List;

@FuncIdentifier("paste")
public class Paste implements Function {
    private final List<Function> attributes;
    private final String sep;

    public Paste(List<Function> attributes, String sep) {
        this.attributes = attributes;
        this.sep = sep;
    }

    public List<Function> getAttributes() {
        return attributes;
    }

    public String getSep() {
        return sep;
    }

    @Override
    public void validate() throws InvalidExpressionException {
        if (attributes == null || attributes.isEmpty()) {
            throw new InvalidExpressionException("attributes argument must not be empty");
        }

        if (sep == null) {
            throw new InvalidExpressionException("sep argument must not be null");
        }
    }
}
