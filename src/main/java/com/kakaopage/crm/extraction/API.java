package com.kakaopage.crm.extraction;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

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

    public static boolean jobExecutionStatus(String job, String execution, String status) {
        String url = String.format("%s/metadata/%s/status/%s", ApplicationProperties.get("api.metadata.base-url"), execution, status);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Void> result = null;
        int retries = Integer.parseInt(ApplicationProperties.get("api.metadata.retries", "2"));
        for (int i = retries; i >= 0; i--) {
            try {
                result = restTemplate.exchange(url, HttpMethod.PATCH, entity, Void.class);
                break;
            } catch (Exception e) {
                if (i == 0) {
                    throw e;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) { }
            }
        }

        return false;
    }
}