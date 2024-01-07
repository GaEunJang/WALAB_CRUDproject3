package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DQLService {
    private Connection connection;

    public DQLService(Connection connection) {
        this.connection = connection;
    }

    public List<ClothingData> getData() {
        List<ClothingData> dataList = new ArrayList<>();
        String sql = "SELECT id, type, name, price, description FROM Clothing";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                ClothingData data = new ClothingData(id, type, name, price, description);
                dataList.add(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataList;
    }

    public List<ClothingData> getDataByType(String type) {
        List<ClothingData> dataList = new ArrayList<>();
        String sql = "SELECT id, type, name, price, description FROM Clothing WHERE type = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String retrievedType = rs.getString("type");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                ClothingData data = new ClothingData(id, retrievedType, name, price, description);
                dataList.add(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dataList;
    }

    public List<ClothingData> getSortedData(String sortBy) {
        List<ClothingData> dataList = new ArrayList<>();
        String sql = "SELECT id, type, name, price, description FROM Clothing ORDER BY " + sortBy;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                ClothingData data = new ClothingData(id, type, name, price, description);
                dataList.add(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dataList;
    }
}
