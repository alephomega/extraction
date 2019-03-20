package com.kakaopage.crm.extraction;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Properties;

class API {
    private static final RestTemplate restTemplate;

    static  {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        Properties properties = loadProperties();
        requestFactory.setConnectTimeout(Integer.parseInt(value(properties, "api.metadata.connect-timeout", "10000")));
        requestFactory.setReadTimeout(Integer.parseInt(value(properties, "api.metadata.read-timeout", "5000")));

        restTemplate = new RestTemplate(requestFactory);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(API.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException ignore) { }

        return properties;
    }

    private static String value(Properties properties, String name, String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }
}
