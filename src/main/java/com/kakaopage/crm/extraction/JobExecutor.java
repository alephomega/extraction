package com.kakaopage.crm.extraction;

import com.google.gson.Gson;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description) {
        Execution execution = new Gson().fromJson(description, Execution.class);
        String id = execution.getId();
        String job = execution.getJob();

        Job metadata = API.job(job);
        String expression = metadata.getExpression();

        Extraction extraction;
        try {
            extraction = Extraction.of(id, job, expression);
        } catch (Exception e) {
            phaseListener.onFailure(job, id, e);
            throw e;
        }

        phaseListener.onStart(job, id);

        try {
            Process process = Serializer.serialize(extraction);

            ExtractionResult result = run(job, id, process);
            phaseListener.onSuccess(job, id, result);

        } catch (Exception e) {
            phaseListener.onFailure(job, id, e);
            throw e;
        }
    }

    public abstract ExtractionResult run(String id, String job, Process process);
}