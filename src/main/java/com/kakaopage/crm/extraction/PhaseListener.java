package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.logging.Logger;

class PhaseListener {
    private static final Logger LOGGER = Logger.getLogger(PhaseListener.class.getSimpleName());
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    void onStart(String id, String job) {
        LOGGER.info("Running PhaseListener.onStart");
        try {
            API.jobStarted(job, id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Failed to change job status: id = %s, job = %s, status = started\n%s", id, job, ExceptionUtils.getStackTrace(e)));
            ExceptionHandlerExecutor.execute(e);
        }
    }

    void onSuccess(String id, String job, Cohort cohort) {
        LOGGER.info("Running PhaseListener.onSuccess");
        String description = GSON.toJson(Target.with(job, id, cohort));
        try {
            API.jobCompleted(job, id, description);
        } catch (Exception e) {
            LOGGER.severe(String.format("Failed to change job status: id = %s, job = %s, status = completed\n%s", id, job, ExceptionUtils.getStackTrace(e)));
            ExceptionHandlerExecutor.execute(e);
        }
    }

    void onFailure(String id, String job, Exception cause) {
        LOGGER.info("Running PhaseListener.onFailed");
        try {
            API.jobFailed(job, id, cause.toString());
        } catch (Exception e) {
            LOGGER.severe(String.format("Failed to change job status: id = %s, job = %s, status = failed\n%s", id, job, ExceptionUtils.getStackTrace(e)));
            ExceptionHandlerExecutor.execute(e);
        }
    }
}