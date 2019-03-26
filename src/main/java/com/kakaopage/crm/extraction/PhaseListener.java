package com.kakaopage.crm.extraction;

import com.google.gson.Gson;

class PhaseListener {
    private static final Gson GSON = new Gson();

    void onStart(String job, String execution) {
        try {
            API.jobStarted(job, execution);
        } catch (Exception e) {
            ExceptionHandlerExecutor.execute(e);
        }
    }

    void onSuccess(String job, String execution, ExtractionResult result) {
        String description = GSON.toJson(TargetDescription.with(job, execution, result));
        try {
            API.jobCompleted(job, execution, description);
        } catch (Exception e) {
            ExceptionHandlerExecutor.execute(e);
        }
    }

    void onFailure(String job, String execution, Exception cause) {
        try {
            API.jobFailed(job, execution, cause.toString());
        } catch (Exception e) {
            ExceptionHandlerExecutor.execute(e);
        }
    }
}