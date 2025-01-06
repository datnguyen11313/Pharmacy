package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;

public class CategoriesDao {

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        try (Connection connection = ConnectDB.getCon();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT category_name FROM Categories")) { 
            while (resultSet.next()) {
                categories.add(resultSet.getString("category_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return categories;
    }
}