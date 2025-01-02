package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.MedicinesEntity;

public class MedicinesDao {

	private CategoriesDAO categoriesDao = new CategoriesDAO(); // Khởi tạo đối tượng CategoriesDao

	// lấy hết dữ liệu bên dưới database ra cái list
	public List<MedicinesEntity> select() {
		List<MedicinesEntity> list = new ArrayList<>();
		try (var con = ConnectDB.getCon();
				var ps = con.prepareStatement("SELECT * FROM medicines WHERE isDelete = 0 ORDER BY id DESC");
				var rs = ps.executeQuery();) {
			while (rs.next()) {
				var medic = new MedicinesEntity();
				medic.setId(rs.getInt("id"));
				medic.setMedicine_name(rs.getString("medicine_name"));

				medic.setCategory_id(rs.getInt("category_id"));
				medic.setPrice(rs.getInt("price"));
				medic.setStock(rs.getInt("stock"));
				medic.setManufacturing_date(rs.getDate("manufacturing_date").toLocalDate());
				medic.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
				medic.setDelete(rs.getBoolean("isDelete"));

				list.add(medic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// insert dữ liệu
	public void insert(MedicinesEntity medic) {
		try (var con = ConnectDB.getCon();
				// var ps = con.prepareStatement("insert into product values(?,?,?)");
				var cs = con.prepareCall("{call insertPro(?,?,?,?,?,?,?)}");) {
			cs.setString(1, medic.getMedicine_name());
			cs.setInt(2, medic.getCategory_id());
			cs.setInt(3, medic.getPrice());
			cs.setInt(4, medic.getStock());
			cs.setDate(5, java.sql.Date.valueOf(medic.getManufacturing_date()));
			cs.setDate(6, java.sql.Date.valueOf(medic.getExpiry_date()));
			cs.setBoolean(7, medic.isDelete());

			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "insert success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Thêm thuốc
	public void addMedicine(MedicinesEntity medicine) {
		String query = "INSERT INTO medicines (medicine_name, category_id, price, stock, manufacturing_date, expiry_date, supplier_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (var con = ConnectDB.getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, medicine.getMedicine_name());
			stmt.setInt(2, medicine.getCategory_id());
			stmt.setDouble(3, medicine.getPrice());
			stmt.setInt(4, medicine.getStock());
			stmt.setDate(5, java.sql.Date.valueOf(medicine.getManufacturing_date()));
			stmt.setDate(6, java.sql.Date.valueOf(medicine.getExpiry_date()));
			stmt.setInt(7, medicine.getSupplier_id()); // Sửa lại tham số thứ 7.

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Cập nhật thông tin thuốc
	public boolean updateMedicine(MedicinesEntity medicine) {
		String query = "UPDATE medicines SET medicine_name = ?, category_id = ?, price = ?, stock = ?, manufacturing_date = ?, expiry_date = ?, supplier_id = ? WHERE id = ?";
		try (var con = ConnectDB.getCon(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, medicine.getMedicine_name());
			ps.setInt(2, medicine.getCategory_id());
			ps.setDouble(3, medicine.getPrice());
			ps.setInt(4, medicine.getStock());
			ps.setDate(5, java.sql.Date.valueOf(medicine.getManufacturing_date()));
			ps.setDate(6, java.sql.Date.valueOf(medicine.getExpiry_date()));
			ps.setInt(7, medicine.getSupplier_id());
			ps.setInt(8, medicine.getId());
			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0; // Trả về true nếu cập nhật thành công
		} catch (Exception e) {
			e.printStackTrace(); // In lỗi ra console để debug
			return false; // Trả về false nếu có lỗi
		}
	}

	// Xóa thuốc trong cơ sở dữ liệu
	public boolean deleteMedicine(int medicineId) {
		String query = "DELETE FROM medicines WHERE id = ?";
		try (var con = ConnectDB.getCon(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, medicineId);
			int rowsDeleted = ps.executeUpdate();
			return rowsDeleted > 0; // Trả về true nếu xóa thành công
		} catch (Exception e) {
			e.printStackTrace(); // In lỗi ra console để debug
			return false; // Trả về false nếu có lỗi
		}
	}

	// Lấy tên loại thuốc từ category_id
	public String getCategoryNameById(int categoryId) {
		return categoriesDao.getCategoryNameById(categoryId); // Gọi phương thức từ CategoriesDao
	}

}
