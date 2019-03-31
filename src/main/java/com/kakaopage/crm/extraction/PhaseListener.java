package com.kakaopage.crm.extraction;

import com.google.gson.Gson;

class PhaseListener {
    private static final Gson GSON = new Gson();

    void onStart(String id, String job) {
        try {
            API.jobStarted(job, id);
        } catch (Exception e) {
            ExceptionHandlerExecutor.execute(e);
        }
    }

    void onSuccess(String id, String job, Cohort cohort) {
        String description = GSON.toJson(Target.with(job, id, cohort));
        try {
            API.jobCompleted(job, id, description);
        } catch (Exception e) {
            ExceptionHandlerExecutor.execute(e);
        }
    }

    void onFailure(String id, String job, Exception cause) {
        try {
            API.jobFailed(job, id, cause.toString());
        } catch (Exception e) {
            ExceptionHandlerExecutor.execute(e);
        }
    }
}