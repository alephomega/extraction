package com.kakaopage.crm.extraction;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties = load();

    private static Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException ignore) { }

        return properties;
    }

    public static String get(String name, String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }
}