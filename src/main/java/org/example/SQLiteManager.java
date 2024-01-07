package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteManager {
    private static SQLiteManager instance = new SQLiteManager();
    private Connection connection;

    //SQLite 연결 시도
    private SQLiteManager() {
        try {
            String url = "jdbc:sqlite:clothing.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("연결 실패", e);
        }
    }

    public static SQLiteManager getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
