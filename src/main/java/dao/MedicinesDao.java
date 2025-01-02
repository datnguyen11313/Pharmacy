package dao;

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

}
