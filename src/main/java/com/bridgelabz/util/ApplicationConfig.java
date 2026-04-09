package com.bridgelabz.util;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = ApplicationConfig.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input != null) {
                props.load(input);
            }

        } catch (Exception ignored) {}
    }

    public static String getRepositoryType() {
        return System.getProperty("repo",
                props.getProperty("repository.type", "cache"));
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
}