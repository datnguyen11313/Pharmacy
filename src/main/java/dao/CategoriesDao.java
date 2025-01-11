package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.CategoriesEntity;

public class CategoriesDao {

	public List<String> getAllCategories() {
		List<String> categories = new ArrayList<>();
		try (var connection = ConnectDB.getCon();
				var statement = connection.createStatement();
				var resultSet = statement.executeQuery("SELECT category_name FROM Categories")) {
			while (resultSet.next()) {
				categories.add(resultSet.getString("category_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public List<CategoriesEntity> getAllCategoriesThinh() {
		List<CategoriesEntity> list = new ArrayList<>();
		try (var con = ConnectDB.getCon();
				var ps = con.prepareStatement("SELECT * FROM categories WHERE isDelete = 0");
				var rs = ps.executeQuery()) {
			while (rs.next()) {
				var category = new CategoriesEntity();
				category.setId(rs.getInt("id"));
				category.setCaterogy_name(rs.getString("category_name"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}