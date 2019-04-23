package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Logger;

class API {
    private static final Logger LOGGER = Logger.getLogger(API.class.getSimpleName());

    private static final Gson GSON = new Gson();
    private static HttpClient client = HttpClientBuilder.create()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(Integer.parseInt(ApplicationProperties.get("api.metadata.connect-timeout", "15000")))
                    .setSocketTimeout(Integer.parseInt(ApplicationProperties.get("api.metadata.read-timeout", "5000"))).build()).build();


    static Job job(String id) {
        String url = String.format("%s/job/%s", ApplicationProperties.get("api.metadata.base-url"), id);

        LOGGER.info("Calling API: " + url);

        HttpGet request = new HttpGet(url);
        request.setHeader("Cache-Control", "no-cache");
        request.setHeader("Content-Type", "application/json");

        HttpResponse httpResponse = execute(request);

        if (httpResponse == null) {
            throw new APICallFailedException("Should not happen");
        }

        String body;
        try {
            body = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new APICallFailedException(e);
        }

        Result result = GSON.fromJson(body, Result.class);
        Map<String, ?> response = result.getResponse();

        int statusCode = httpResponse.getStatusLine().getStatusCode();

        if (statusCode < 200 || statusCode >= 300) {
            throw new APICallFailedException(result.getMessage());
        }

        String name = (String) response.get("jobName");
        String expression = (String) response.get("relationExp");

        return new Job(id, name, expression);
    }

    private static HttpResponse execute(HttpRequestBase request) {
        int retries = Integer.parseInt(ApplicationProperties.get("api.metadata.retries", "2"));

        HttpResponse httpResponse = null;
        for (int i = retries; i >= 0; i--) {

            LOGGER.info("Requesting: " + request);
            try {
                httpResponse = client.execute(request);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (!timeout(statusCode)) {
                    break;
                }
            } catch (Exception e) {
                if (i == 0) {
                    throw new APICallFailedException(e);
                }

                try {
                    Thread.sleep(2000 * (retries-i+1));
                } catch (InterruptedException ignored) { }
            }
        }

        LOGGER.info("Response:\n" + httpResponse);
        return httpResponse;
    }

    private static boolean timeout(int statusCode) {
        return (statusCode == HttpStatus.SC_REQUEST_TIMEOUT || statusCode == HttpStatus.SC_GATEWAY_TIMEOUT);
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

    private static void jobExecutionStatus(String job, String execution, String status, String requestBeody) {
        String url = String.format("%s/metadata/%s/status/%s", ApplicationProperties.get("api.metadata.base-url"), execution, status);
        LOGGER.info("Calling API: " + url);

        HttpPatch request = new HttpPatch(url);
        request.setHeader("Cache-Control", "no-cache");
        request.setHeader("Content-Type", "application/json");

        ByteArrayEntity entity = new ByteArrayEntity(requestBeody.getBytes(Charset.forName("UTF-8")));
        entity.setContentType("application/json");
        request.setEntity(entity);

        HttpResponse httpResponse = execute(request);
        if (httpResponse == null) {
            throw new APICallFailedException("Should not happen");
        }

        String responseBody;
        try {
            responseBody = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            throw new APICallFailedException(e);
        }

        Result result = GSON.fromJson(responseBody, Result.class);

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode >= 300) {
            throw new APICallFailedException(result.getMessage());
        }
    }

    private static class Result {
        private String message;
        private Map<String, ?> response;
        private String timestamp;

        Result() { }
        Result(String message, Map<String, ?> response, String timestamp) {
            this.message = message;
            this.response = response;
            this.timestamp = timestamp;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setResponse(Map<String, ?> response) {
            this.response = response;
        }

        public void setTimestamp(String timestamp) {
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

    public static void main(String[] args) {
        Job job = API.job("20");
        String expression = job.getExpression();
        System.out.println(expression);
    }
}