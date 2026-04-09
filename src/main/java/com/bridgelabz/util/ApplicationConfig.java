package com.bridgelabz.util;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = ApplicationConfig.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            props.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static String getDbUrl() {
        return props.getProperty("db.url");
    }

    public static String getDbUser() {
        return props.getProperty("db.user");
    }

    public static String getDbPassword() {
        return props.getProperty("db.password");
    }

    public static String getRepositoryType() {
        return props.getProperty("repository.type", "cache");
    }
}