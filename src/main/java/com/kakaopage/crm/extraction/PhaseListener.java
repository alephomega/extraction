package com.kakaopage.crm.extraction;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Properties;

class PhaseListener {

    private RestTemplate restTemplate;

    PhaseListener() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        Properties properties = loadProperties();
        requestFactory.setConnectTimeout(
                Integer.parseInt(value(properties, "api.metadata.connect-timeout", "10000")));

        requestFactory.setReadTimeout(
                Integer.parseInt(value(properties, "api.metadata.read-timeout", "5000")));

        this.restTemplate = new RestTemplate(requestFactory);
    }

    void onStart(String id) {

    }

    void onSuccess(String id, ExtractionResult result) {

    }

    void onFailure(String id, Exception e) {

    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException ignore) { }

        return properties;
    }

    private static String value(Properties properties, String name, String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }
}