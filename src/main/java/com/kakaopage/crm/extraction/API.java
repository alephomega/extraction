package com.kakaopage.crm.extraction;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

class API {
    private static final RestTemplate restTemplate;

    static  {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(
                Integer.parseInt(ApplicationProperties.get("api.metadata.connect-timeout", "10000")));

        requestFactory.setReadTimeout(
                Integer.parseInt(ApplicationProperties.get("api.metadata.read-timeout", "5000")));

        restTemplate = new RestTemplate(requestFactory);
    }

    static void job(String id) {

    }

    static void jobStarted(String job, String execution) {
        jobExecutionStatus(job, execution, "running", null);
    }

    static void jobCompleted(String job, String execution, String targetDescription) {
        jobExecutionStatus(job, execution, "completed", targetDescription);
    }

    static void jobFailed(String job, String execution, String message) {
        jobExecutionStatus(job, execution, "failed", message);
    }

    private static void jobExecutionStatus(String job, String execution, String status, String body) {
        String url = String.format("%s/metadata/%s/status/%s", ApplicationProperties.get("api.metadata.base-url"), execution, status);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Response> result = null;
        int retries = Integer.parseInt(ApplicationProperties.get("api.metadata.retries", "2"));
        for (int i = retries; i >= 0; i--) {
            try {
                result = restTemplate.exchange(url, HttpMethod.PATCH, entity, Response.class);
                break;
            } catch (Exception e) {
                if (i == 0) {
                    throw new APICallFailedException(e);
                }

                try {
                    Thread.sleep(1000 * (retries-i+1));
                } catch (InterruptedException ignored) { }
            }
        }

        if (result == null) {
            throw new APICallFailedException("Should not happen");
        }

        if (!result.getStatusCode().is2xxSuccessful()) {
            throw new APICallFailedException(result.getBody().getMessage());
        }
    }

    private static class Response {
        private final String message;
        private final Map<String, ?> response;
        private final String timestamp;

        Response(String message, Map<String, ?> response, String timestamp) {
            this.message = message;
            this.response = response;
            this.timestamp = timestamp;
        }

        private String getMessage() {
            return message;
        }

        private Map<String, ?> getResponse() {
            return response;
        }

        private String getTimestamp() {
            return timestamp;
        }
    }
}