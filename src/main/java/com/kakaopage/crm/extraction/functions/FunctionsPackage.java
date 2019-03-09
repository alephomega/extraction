package com.kakaopage.crm.extraction.functions;

public class FunctionsPackage {
    public static String getName() {
        return FunctionsPackage.class.getPackage().getName();
    }
}
