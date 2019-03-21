package com.kakaopage.crm.extraction;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description) {
        Extraction extraction = Extraction.of(description);

        String job = extraction.getJob();
        String execution = extraction.getExecution();

        phaseListener.onStart(job, execution);

        try {
            Process process = Serializer.serialize(extraction);

            ExtractionResult result = run(job, execution, process);
            phaseListener.onSuccess(job, execution, result);

        } catch (Exception e) {
            phaseListener.onFailure(job, execution, e);
        }
    }

    public abstract ExtractionResult run(String job, String execution, Process process);
}