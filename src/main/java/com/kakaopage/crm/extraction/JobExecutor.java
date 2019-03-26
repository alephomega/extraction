package com.kakaopage.crm.extraction;

import com.google.gson.Gson;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description) {
        Extraction extraction;
        try {
            extraction = Extraction.of(description);
        } catch (Exception e) {
            ExecutionKey key = new Gson().fromJson(description, ExecutionKey.class);
            phaseListener.onFailure(key.job, key.execution, e);

            throw e;
        }

        String job = extraction.getJob();
        String execution = extraction.getExecution();

        phaseListener.onStart(job, execution);

        try {
            Process process = Serializer.serialize(extraction);

            ExtractionResult result = run(job, execution, process);
            phaseListener.onSuccess(job, execution, result);

        } catch (Exception e) {
            phaseListener.onFailure(job, execution, e);
            throw e;
        }
    }

    public abstract ExtractionResult run(String job, String execution, Process process);

    private static class ExecutionKey {
        private final String job;
        private final String execution;

        private ExecutionKey(String job, String execution) {
            this.job = job;
            this.execution = execution;
        }
    }
}