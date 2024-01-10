package org.example;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DDLService {
    private Connection connection;

    public DDLService(Connection connection) {
        this.connection = connection;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Clothing (" +
                "id INTEGER PRIMARY KEY," +
                "type VARCHAR NOT NULL," +
                "name VARCHAR NOT NULL," +
                "price INTEGER NOT NULL," +
                "description TEXT,"+
                "registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
