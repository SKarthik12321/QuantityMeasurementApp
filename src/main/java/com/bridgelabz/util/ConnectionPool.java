package com.bridgelabz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class ConnectionPool {

    private static final LinkedList<Connection> pool = new LinkedList<>();

    static {
        try {
            Class.forName(ApplicationConfig.get("db.driver"));

            int size = Integer.parseInt(ApplicationConfig.get("db.pool.size"));

            for (int i = 0; i < size; i++) {
                pool.add(createConnection());
            }

        } catch (Exception e) {
            throw new RuntimeException("Pool init failed");
        }
    }

    private static Connection createConnection() throws Exception {
        return DriverManager.getConnection(
                ApplicationConfig.get("db.url"),
                ApplicationConfig.get("db.username"),
                ApplicationConfig.get("db.password")
        );
    }

    public static synchronized Connection getConnection() {
        if (pool.isEmpty()) throw new RuntimeException("No connections available");
        return pool.removeFirst();
    }

    public static synchronized void release(Connection conn) {
        pool.addLast(conn);
    }
}
