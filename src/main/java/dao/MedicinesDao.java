package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	    String sql = "SELECT "
	                + "m.id, m.medicine_name, m.price, m.stock, m.unit, m.manufacturing_date, m.expiry_date, m.picture, m.isDelete, m.concentration, m.usage, m.contraindications, m.side_effects, m.storage, m.ingredients, "  // Chọn tất cả các cột của Medicines
	                + "c.id AS category_id, c.category_name, " 
	                + "s.id AS supplier_id, s.supplier_name " 
	                + "FROM Medicines m "
	                + "JOIN Categories c ON m.category_id = c.id "
	                + "JOIN Suppliers s ON m.supplier_id = s.id "
	                + "WHERE c.category_name = ?"; 

	    try (Connection connection = ConnectDB.getCon();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, categoryName);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
	    String sql = "SELECT "
	                + "m.id, m.medicine_name, m.price, m.stock, m.unit, m.manufacturing_date, m.expiry_date, m.picture, m.isDelete, m.concentration, m.usage, m.contraindications, m.side_effects, m.storage, m.ingredients, "  // Chọn tất cả các cột của Medicines
	                + "c.id AS category_id, c.category_name, " 
	                + "s.id AS supplier_id, s.supplier_name " 
	                + "FROM Medicines m "
	                + "JOIN Categories c ON m.category_id = c.id "
	                + "JOIN Suppliers s ON m.supplier_id = s.id "
	                + "WHERE m.medicine_name LIKE ? OR c.category_name LIKE ?"; 

	    try (Connection connection = ConnectDB.getCon();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, "%" + searchText + "%");
	        preparedStatement.setString(2, "%" + searchText + "%");
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
}
