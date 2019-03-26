package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description) {
        Extraction extraction;
        try {
            extraction = Extraction.of(description);
        } catch (Exception e) {
            Map<String, ?> descriptionMap = new Gson().fromJson(description, new TypeToken<Map<String, ?>>(){}.getType());
            String job = (String) descriptionMap.get("job");
            String execution = (String) descriptionMap.get("execution");

            if (job != null && execution != null) {
                phaseListener.onFailure(job, execution, e);
            }

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
}