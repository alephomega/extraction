package com.kakaopage.crm.extraction;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description) {
        Extraction extraction = Extraction.of(description);

        String id = extraction.getId();
        phaseListener.onStart(id);

        try {
            Process process = Serializer.serialize(extraction);

            ExtractionResult result = run(id, process);
            phaseListener.onSuccess(id, result);

        } catch (Exception e) {
            phaseListener.onFailure(id, e);
        }
    }

    public abstract ExtractionResult run(String id, Process process);
}