package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.CategoriesEntity;
import entity.MedicinesEntity;
import entity.SupplierEntity;

public class MedicinesDao {

	// lấy hết dữ liệu bên dưới database ra cái list
	public List<MedicinesEntity> select() {
		List<MedicinesEntity> list = new ArrayList<>();
		try (var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getMedicines()}");
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var medic = new MedicinesEntity();
				// Tạo đối tượng CategoriesEntity
				var category = new CategoriesEntity();
				// Lấy category_name từ ResultSet
				var categoryName = rs.getString("category_name");

				category.setId(rs.getInt("category_id"));
				category.setCaterogy_name(categoryName);

				var supplier = new SupplierEntity();
				supplier.setId(rs.getInt("supplier_id"));
				supplier.setSupplier_name(rs.getString("supplier_name"));

				medic.setId(rs.getInt("id"));
				medic.setMedicine_name(rs.getString("medicine_name"));
				medic.setCategory(category); // Gán CategoriesEntity cho MedicinesEntity

				medic.setPrice(rs.getBigDecimal("price"));
				medic.setStock(rs.getInt("stock"));
				medic.setManufacturing_date(rs.getDate("manufacturing_date").toLocalDate());
				medic.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
				medic.setPicture(rs.getString("picture"));
				medic.setDelete(rs.getBoolean("isDelete"));
				medic.setSupplier(supplier);
				medic.setUnit(rs.getString("unit"));
				medic.setConcentration(rs.getString("concentration"));
				medic.setUsage(rs.getString("usage"));
				medic.setContraindications(rs.getString("contraindications"));
				medic.setSide_effects(rs.getString("side_effects"));
				medic.setStorage(rs.getString("storage"));
				medic.setIngredients(rs.getString("ingredients"));

				list.add(medic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public MedicinesEntity getMedicineByName(String medicineName) {
		MedicinesEntity medic = null;
		try (var con = ConnectDB.getCon(); var cs = con.prepareCall("{call getMedicineByName(?)}");) {
			cs.setString(1, medicineName);
			try (var rs = cs.executeQuery();) {
				if (rs.next()) {
					medic = new MedicinesEntity();
					// Lấy category_name từ ResultSet
					var categoryName = rs.getString("category_name");
					// Tạo đối tượng CategoriesEntity
					var category = new CategoriesEntity();
					category.setId(rs.getInt("category_id"));
					category.setCaterogy_name(categoryName);

					var supplier = new SupplierEntity();
					supplier.setId(rs.getInt("supplier_id"));
					supplier.setSupplier_name(rs.getString("supplier_name"));

					medic.setId(rs.getInt("id"));
					medic.setMedicine_name(rs.getString("medicine_name"));
					medic.setCategory(category);
					medic.setPrice(rs.getBigDecimal("price"));
					medic.setStock(rs.getInt("stock"));
					medic.setManufacturing_date(rs.getDate("manufacturing_date").toLocalDate());
					medic.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
					medic.setPicture(rs.getString("picture"));

					medic.setDelete(rs.getBoolean("isDelete"));
					medic.setSupplier(supplier);
					medic.setUnit(rs.getString("unit"));
					medic.setConcentration(rs.getString("concentration"));
					medic.setUsage(rs.getString("usage"));
					medic.setContraindications(rs.getString("contraindications"));
					medic.setSide_effects(rs.getString("side_effects"));
					medic.setStorage(rs.getString("storage"));
					medic.setIngredients(rs.getString("ingredients"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medic;
	}

	public List<MedicinesEntity> getMedicinesByCategory(String categoryName) {
		List<MedicinesEntity> medicines = new ArrayList<>();
		var sql = "SELECT "
				+ "m.id, m.medicine_name, m.price, m.stock, m.unit, m.manufacturing_date, m.expiry_date, m.picture, m.isDelete, m.concentration, m.usage, m.contraindications, m.side_effects, m.storage, m.ingredients, " // Chọn
																																																							// tất
																																																							// cả
																																																							// các
																																																							// cột
																																																							// của
																																																							// Medicines
				+ "c.id AS category_id, c.category_name, " + "s.id AS supplier_id, s.supplier_name "
				+ "FROM Medicines m " + "JOIN Categories c ON m.category_id = c.id "
				+ "JOIN Suppliers s ON m.supplier_id = s.id " + "WHERE c.category_name = ?";

		try (var connection = ConnectDB.getCon(); var preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, categoryName);
			try (var resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					var medic = new MedicinesEntity();

					// Tạo đối tượng CategoriesEntity
					var category = new CategoriesEntity();
					category.setId(resultSet.getInt("category_id"));
					category.setCaterogy_name(resultSet.getString("category_name")); // Sửa lỗi chính tả

					// Tạo đối tượng SupplierEntity
					var supplier = new SupplierEntity();
					supplier.setId(resultSet.getInt("supplier_id"));
					supplier.setSupplier_name(resultSet.getString("supplier_name"));

					// Gán giá trị cho MedicinesEntity
					medic.setId(resultSet.getInt("id"));
					medic.setMedicine_name(resultSet.getString("medicine_name"));
					medic.setCategory(category);
					medic.setPrice(resultSet.getBigDecimal("price"));
					medic.setStock(resultSet.getInt("stock"));
					medic.setManufacturing_date(resultSet.getDate("manufacturing_date").toLocalDate());
					medic.setExpiry_date(resultSet.getDate("expiry_date").toLocalDate());
					medic.setPicture(resultSet.getString("picture"));
					medic.setDelete(resultSet.getBoolean("isDelete"));
					medic.setSupplier(supplier);
					medic.setUnit(resultSet.getString("unit"));
					medic.setConcentration(resultSet.getString("concentration"));
					medic.setUsage(resultSet.getString("usage"));
					medic.setContraindications(resultSet.getString("contraindications"));
					medic.setSide_effects(resultSet.getString("side_effects"));
					medic.setStorage(resultSet.getString("storage"));
					medic.setIngredients(resultSet.getString("ingredients"));

					medicines.add(medic);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicines;
	}

	public List<MedicinesEntity> searchMedicines(String searchText) {
		List<MedicinesEntity> medicines = new ArrayList<>();
		var sql = "SELECT "
				+ "m.id, m.medicine_name, m.price, m.stock, m.unit, m.manufacturing_date, m.expiry_date, m.picture, m.isDelete, m.concentration, m.usage, m.contraindications, m.side_effects, m.storage, m.ingredients, " // Chọn
																																																							// tất
																																																							// cả
																																																							// các
																																																							// cột
																																																							// của
																																																							// Medicines
				+ "c.id AS category_id, c.category_name, " + "s.id AS supplier_id, s.supplier_name "
				+ "FROM Medicines m " + "JOIN Categories c ON m.category_id = c.id "
				+ "JOIN Suppliers s ON m.supplier_id = s.id "
				+ "WHERE m.medicine_name LIKE ? OR c.category_name LIKE ?";

		try (var connection = ConnectDB.getCon(); var preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, "%" + searchText + "%");
			preparedStatement.setString(2, "%" + searchText + "%");
			try (var resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					var medic = new MedicinesEntity();

					// Tạo đối tượng CategoriesEntity
					var category = new CategoriesEntity();
					category.setId(resultSet.getInt("category_id"));
					category.setCaterogy_name(resultSet.getString("category_name"));

					// Tạo đối tượng SupplierEntity
					var supplier = new SupplierEntity();
					supplier.setId(resultSet.getInt("supplier_id"));
					supplier.setSupplier_name(resultSet.getString("supplier_name"));

					// Gán giá trị cho MedicinesEntity
					medic.setId(resultSet.getInt("id"));
					medic.setMedicine_name(resultSet.getString("medicine_name"));
					medic.setCategory(category);
					medic.setPrice(resultSet.getBigDecimal("price"));
					medic.setStock(resultSet.getInt("stock"));
					medic.setManufacturing_date(resultSet.getDate("manufacturing_date").toLocalDate());
					medic.setExpiry_date(resultSet.getDate("expiry_date").toLocalDate());
					medic.setPicture(resultSet.getString("picture"));
					medic.setDelete(resultSet.getBoolean("isDelete"));
					medic.setSupplier(supplier);
					medic.setUnit(resultSet.getString("unit"));
					medic.setConcentration(resultSet.getString("concentration"));
					medic.setUsage(resultSet.getString("usage"));
					medic.setContraindications(resultSet.getString("contraindications"));
					medic.setSide_effects(resultSet.getString("side_effects"));
					medic.setStorage(resultSet.getString("storage"));
					medic.setIngredients(resultSet.getString("ingredients"));

					medicines.add(medic);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicines;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// PHẦN CỦA THỊNH
///
///

	public void addMedicine(MedicinesEntity medicine) {
		try (var con = ConnectDB.getCon();
				var ps = con.prepareStatement(
						"INSERT INTO medicines (medicine_name, category_id, supplier_id, price, stock, manufacturing_date, expiry_date, picture, created_at, updated_at, isDelete, unit, concentration, usage, contraindications, side_effects, storage, ingredients) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			ps.setString(1, medicine.getMedicine_name());
			ps.setInt(2, medicine.getCategory().getId());
			ps.setInt(3, medicine.getSupplier().getId());
			ps.setBigDecimal(4, medicine.getPrice());
			ps.setInt(5, medicine.getStock());
			ps.setDate(6, java.sql.Date.valueOf(medicine.getManufacturing_date()));
			ps.setDate(7, java.sql.Date.valueOf(medicine.getExpiry_date()));

			// Lưu đường dẫn ảnh thay vì dữ liệu nhị phân
			if (!medicine.getPicture().isEmpty()) {
				ps.setString(8, medicine.getPicture()); // Lưu đường dẫn ảnh
			} else {
				ps.setNull(8, Types.VARCHAR); // Nếu không có ảnh, gán NULL
			}

			// Cập nhật thời gian created_at và updated_at
			var now = LocalDateTime.now();
			ps.setTimestamp(9, Timestamp.valueOf(now)); // created_at
			ps.setTimestamp(10, Timestamp.valueOf(now)); // updated_at

			ps.setBoolean(11, false); // isDelete mặc định là false
			ps.setString(12, medicine.getUnit());
			ps.setString(13, medicine.getConcentration());
			ps.setString(14, medicine.getUsage());
			ps.setString(15, medicine.getContraindications());
			ps.setString(16, medicine.getSide_effects());
			ps.setString(17, medicine.getStorage());
			ps.setString(18, medicine.getIngredients());

			// Thực thi câu lệnh SQL
			var rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Thêm thuốc thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Không thể thêm thuốc. Vui lòng thử lại!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi thêm thuốc vào cơ sở dữ liệu!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public MedicinesEntity getMedicineById(int id) {
		MedicinesEntity medicine = null;
		var query = """
				SELECT m.*, c.category_name, s.supplier_name
				FROM medicines m
				JOIN categories c ON m.category_id = c.id
				JOIN suppliers s ON m.supplier_id = s.id
				WHERE m.id = ?;
				""";

		try (var con = ConnectDB.getCon(); var ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					medicine = new MedicinesEntity();
					// Điền dữ liệu từ ResultSet vào MedicinesEntity
					var category = new CategoriesEntity();
					category.setId(rs.getInt("category_id"));
					category.setCaterogy_name(rs.getString("category_name"));

					var supplier = new SupplierEntity();
					supplier.setId(rs.getInt("supplier_id"));
					supplier.setSupplier_name(rs.getString("supplier_name"));

					medicine.setId(rs.getInt("id"));
					medicine.setMedicine_name(rs.getString("medicine_name"));
					medicine.setCategory(category);
					medicine.setPrice(rs.getBigDecimal("price"));
					medicine.setStock(rs.getInt("stock"));
					medicine.setManufacturing_date(rs.getDate("manufacturing_date").toLocalDate());
					medicine.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
					medicine.setPicture(rs.getString("picture"));
					medicine.setDelete(rs.getBoolean("isDelete"));
					medicine.setSupplier(supplier);
					medicine.setUnit(rs.getString("unit"));
					medicine.setConcentration(rs.getString("concentration"));
					medicine.setUsage(rs.getString("usage"));
					medicine.setContraindications(rs.getString("contraindications"));
					medicine.setSide_effects(rs.getString("side_effects"));
					medicine.setStorage(rs.getString("storage"));
					medicine.setIngredients(rs.getString("ingredients"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicine;
	}

	public void updateMedicine(MedicinesEntity medicine) {
		var query = """
				UPDATE medicines
				SET medicine_name = ?,
				    category_id = ?,
				    supplier_id = ?,
				    price = ?,
				    stock = ?,
				    manufacturing_date = ?,
				    expiry_date = ?,
				    picture = ?,
				    updated_at = ?,
				    isDelete = ?,
				    unit = ?,
				    concentration = ?,
				    usage = ?,
				    contraindications = ?,
				    side_effects = ?,
				    storage = ?,
				    ingredients = ?
				WHERE id = ?;
				""";

		try (var con = ConnectDB.getCon(); var ps = con.prepareStatement(query)) {
			ps.setString(1, medicine.getMedicine_name());
			ps.setInt(2, medicine.getCategory().getId());
			ps.setInt(3, medicine.getSupplier().getId());
			ps.setBigDecimal(4, medicine.getPrice());
			ps.setInt(5, medicine.getStock());
			ps.setDate(6, java.sql.Date.valueOf(medicine.getManufacturing_date()));
			ps.setDate(7, java.sql.Date.valueOf(medicine.getExpiry_date()));

			if (!medicine.getPicture().isEmpty()) {
				ps.setString(8, medicine.getPicture());
			} else {
				ps.setNull(8, Types.VARCHAR);
			}

			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
			ps.setBoolean(10, medicine.isDelete());
			ps.setString(11, medicine.getUnit());
			ps.setString(12, medicine.getConcentration());
			ps.setString(13, medicine.getUsage());
			ps.setString(14, medicine.getContraindications());
			ps.setString(15, medicine.getSide_effects());
			ps.setString(16, medicine.getStorage());
			ps.setString(17, medicine.getIngredients());
			ps.setInt(18, medicine.getId()); // ID được dùng để tìm đúng bản ghi cần update

			var rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thuốc thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Không thể cập nhật thuốc. Vui lòng thử lại!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật thuốc trong cơ sở dữ liệu!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteMedicineById(int id) {
		var query = "UPDATE medicines SET isDelete = 1 WHERE id = ?";
		try (var con = ConnectDB.getCon(); var ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			var rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Xóa thuốc thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Không thể xóa thuốc. Vui lòng thử lại!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi xóa thuốc!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean updateIsDelete(int medicineId, int isDelete) {
		var sql = "UPDATE medicines SET isDelete = ? WHERE id = ?";
		try (var conn = ConnectDB.getCon(); var stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, isDelete);
			stmt.setInt(2, medicineId);
			return stmt.executeUpdate() > 0; // Trả về true nếu cập nhật thành công
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
