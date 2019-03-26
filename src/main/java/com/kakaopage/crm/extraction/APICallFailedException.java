package com.kakaopage.crm.extraction;

public class APICallFailedException extends RuntimeException {
    public APICallFailedException(Throwable cause) {
        super(cause);
    }

    public APICallFailedException(String msg) {
        super(msg);
    }
}
