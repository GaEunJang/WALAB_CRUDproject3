package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLService {
    private Connection connection;

    public DMLService(Connection connection) {
        this.connection = connection;
    }

    public void insertData(ClothingData data) {
        String sql = "INSERT INTO Clothing (type, name, price, description) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, data.getType());
            pstmt.setString(2, data.getName());
            pstmt.setInt(3, data.getPrice());
            pstmt.setString(4, data.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateData(ClothingData data) {
        String sql = "UPDATE Clothing SET type = ?, name = ?, price = ?, description = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, data.getType());
            pstmt.setString(2, data.getName());
            pstmt.setInt(3, data.getPrice());
            pstmt.setString(4, data.getDescription());
            pstmt.setInt(5, data.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(int id) {
        String sql = "DELETE FROM Clothing WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
