package com.bridgelabz.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    private static final String URL = ApplicationConfig.get("db.url");
    private static final String USER = ApplicationConfig.get("db.user");
    private static final String PASS = ApplicationConfig.get("db.password");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("DB Connection failed", e);
        }
    }
}