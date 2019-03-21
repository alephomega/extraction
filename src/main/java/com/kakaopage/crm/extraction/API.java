package com.kakaopage.crm.extraction;

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
}