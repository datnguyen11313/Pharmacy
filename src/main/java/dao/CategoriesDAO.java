package dao;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import database.ConnectDB;

public class CategoriesDAO {

	// Phương thức lấy danh sách các category từ DB
	public List<Map.Entry<Integer, String>> getAllCategories() {
		List<Map.Entry<Integer, String>> categories = new ArrayList<>();
		String query = "SELECT id, category_name FROM categories WHERE isDelete = 0";

		try (var con = ConnectDB.getCon(); var ps = con.prepareStatement(query); var rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("category_name");
				categories.add(new AbstractMap.SimpleEntry<>(id, name));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error while fetching categories: " + e.getMessage());
		}
		return categories;
	}

	// Lấy tên loại thuốc từ category_id
	public String getCategoryNameById(int categoryId) {
		String categoryName = "Unknown"; // Mặc định nếu không tìm thấy
		String query = "SELECT category_name FROM categories WHERE id = ?";

		try (var con = ConnectDB.getCon(); var ps = con.prepareStatement(query)) {
			ps.setInt(1, categoryId);
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					categoryName = rs.getString("category_name");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryName;
	}
}
