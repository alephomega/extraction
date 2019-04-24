package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Map;
import java.util.logging.Logger;

public abstract class JobExecutor {
    private static final Logger LOGGER = Logger.getLogger(JobExecutor.class.getSimpleName());

    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description, Map<String, String> params) {
        Execution execution = new Gson().fromJson(description, Execution.class);
        String id = execution.getId();
        String job = execution.getJob();

        LOGGER.info(String.format("Extraction job execution: id = %s, job = %s", id, job));

        LOGGER.info("Getting job metadata");
        Job metadata;
        try {
            metadata = API.job(job);
        } catch (Exception e) {
            LOGGER.severe("Failed to get job metadata:\n" + ExceptionUtils.getStackTrace(e));
            throw e;
        }

        LOGGER.info("Running macros");
        String expression = Macros.apply(metadata.getExpression(), params);

        LOGGER.info("Extraction expression:\n" + expression);

        Extraction extraction;
        try {
            extraction = Extraction.of(id, job, expression);
        } catch (Exception e) {
            LOGGER.severe(String.format("Extraction job failed: id = %s, job = %s\n%s", id, job, ExceptionUtils.getStackTrace(e)));
            phaseListener.onFailure(id, job, e);
            throw e;
        }

        phaseListener.onStart(id, job);

        try {
            LOGGER.info("Serializing extraction steps");
            Process process = Serializer.serialize(extraction);

            LOGGER.info("Running steps");
            Cohort cohort = run(job, id, process);

            LOGGER.info("Cohort extracted: " + cohort);

            phaseListener.onSuccess(id, job, cohort);

        } catch (Exception e) {
            LOGGER.severe(String.format("Extraction job failed: id = %s, job = %s\n%s", id, job, ExceptionUtils.getStackTrace(e)));
            phaseListener.onFailure(id, job, e);
            throw e;
        }
    }

    public abstract Cohort run(String job, String id, Process process);
}