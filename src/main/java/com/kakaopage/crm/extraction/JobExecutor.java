package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public abstract class JobExecutor {
    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description, Map<String, String> params) {
        Execution execution = new Gson().fromJson(replace(description, params), Execution.class);
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

    private String replace(String description, Map<String, String> params) {
        String rs = description;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            rs = StringUtils.replace(description, String.format("${%s}", key), entry.getValue());
        }

        return rs;
    }


    public abstract ExtractionResult run(String id, String job, Process process);
}