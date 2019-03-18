package com.kakaopage.crm.extraction;

import java.util.List;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description) {
        Extraction extraction = Extraction.of(description);

        String id = extraction.getId();
        phaseListener.onStart(id);

        try {
            List<Step> steps = Serializer.serialize(extraction);

            JobResult result = run(id, steps);
            phaseListener.onSuccess(id, result);

        } catch (Exception e) {
            phaseListener.onFailure(id, e);
        }
    }

    public abstract JobResult run(String id, List<Step> steps);
}