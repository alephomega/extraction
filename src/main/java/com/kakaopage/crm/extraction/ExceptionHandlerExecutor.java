package com.kakaopage.crm.extraction;

import java.util.ArrayList;
import java.util.List;

class ExceptionHandlerExecutor {
    private static final List<ExceptionHandler> handlers;

    static {
        handlers = new ArrayList<>();
    }

    static void execute(Throwable ex) {
        for (ExceptionHandler handler : handlers) {
            handler.handle(ex);
        }
    }
}
