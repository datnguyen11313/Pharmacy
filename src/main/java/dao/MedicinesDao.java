package dao;

import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.MedicinesEntity;

public class MedicinesDao {

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
				medic.setPrice(rs.getBigDecimal("price"));
				medic.setStock(rs.getInt("stock"));
				medic.setManufacturing_date(rs.getDate("manufacturing_date").toLocalDate());
				medic.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
				medic.setPicture(rs.getString("picture"));
				medic.setDelete(rs.getBoolean("isDelete"));
				medic.setSupplier_id(rs.getInt("supplier_id"));
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
					medic.setId(rs.getInt("id"));
					medic.setMedicine_name(rs.getString("medicine_name"));
					medic.setCategory_id(rs.getInt("category_id"));
					medic.setPrice(rs.getBigDecimal("price"));
					medic.setStock(rs.getInt("stock"));
					medic.setManufacturing_date(rs.getDate("manufacturing_date").toLocalDate());
					medic.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
					medic.setPicture(rs.getString("picture"));

					medic.setDelete(rs.getBoolean("isDelete"));
					medic.setSupplier_id(rs.getInt("supplier_id"));
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
