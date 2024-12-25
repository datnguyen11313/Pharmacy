package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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

}
