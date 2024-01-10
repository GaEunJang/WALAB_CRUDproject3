package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteManager {
    private static SQLiteManager instance = new SQLiteManager();
    private Connection connection;

    private SQLiteManager() {
        connectDatabase();
    }

    public static SQLiteManager getInstance() {
        if (instance.connection == null || instance.isConnectionClosed()) {
            instance.connectDatabase();
        }
        return instance;
    }

    private boolean isConnectionClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            System.out.println("연결 상태 확인 중 오류 발생: " + e.getMessage());
            return true;
        }
    }

    private void connectDatabase() {
        try {
            String url = "jdbc:sqlite:clothing.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("연결 실패", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
