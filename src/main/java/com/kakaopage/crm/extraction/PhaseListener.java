package com.kakaopage.crm.extraction;

import com.google.gson.Gson;

class PhaseListener {
    private static final Gson GSON = new Gson();

    void onStart(String job, String execution) {

    }

    void onSuccess(String job, String execution, ExtractionResult result) {
        String description = GSON.toJson(TargetDescription.with(job, execution, result));

    }

    void onFailure(String job, String execution, Exception e) {

    }
}