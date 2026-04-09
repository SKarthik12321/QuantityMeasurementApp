package com.bridgelabz.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    ApplicationConfig.getDbUrl(),
                    ApplicationConfig.getDbUser(),
                    ApplicationConfig.getDbPassword()
            );
        } catch (Exception e) {
            throw new RuntimeException("DB Connection failed", e);
        }
    }
}