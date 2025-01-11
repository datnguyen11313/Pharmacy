package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.SupplierEntity;

public class SuppliersDao {
	public List<SupplierEntity> getAllSuppliers() {
		List<SupplierEntity> list = new ArrayList<>();
		try (var con = ConnectDB.getCon();
				var ps = con.prepareStatement("SELECT * FROM suppliers WHERE isDelete = 0");
				var rs = ps.executeQuery()) {
			while (rs.next()) {
				var supplier = new SupplierEntity();
				supplier.setId(rs.getInt("id"));
				supplier.setSupplier_name(rs.getString("supplier_name"));
				list.add(supplier);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertSupplier(SupplierEntity supplier) {
		var query = "INSERT INTO Supplier (supplier_name, contact_phone, contact_email, address, isDelete, picture, created_at, updated_at) "
				+ "VALUES (?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
		try (var conn = ConnectDB.getCon(); var ps = conn.prepareStatement(query)) {
			ps.setString(1, supplier.getSupplier_name());
			ps.setString(2, supplier.getContact_phone());
			ps.setString(3, supplier.getContact_email());
			ps.setString(4, supplier.getAddress());
			ps.setBoolean(5, false); // Khi thêm mới, isDelete mặc định là false
			ps.setString(6, supplier.getPicture());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<SupplierEntity> selectSuppliers() {
		List<SupplierEntity> suppliers = new ArrayList<>();
		var query = "SELECT * FROM Supplier WHERE isDelete = 0"; // Lấy danh sách supplier chưa bị xóa
		try (var conn = ConnectDB.getCon(); var ps = conn.prepareStatement(query); var rs = ps.executeQuery()) {
			while (rs.next()) {
				var supplier = new SupplierEntity();
				supplier.setId(rs.getInt("id"));
				supplier.setSupplier_name(rs.getString("supplier_name"));
				supplier.setContact_phone(rs.getString("contact_phone"));
				supplier.setContact_email(rs.getString("contact_email"));
				supplier.setAddress(rs.getString("address"));
				supplier.setDelete(rs.getBoolean("isDelete"));
				supplier.setPicture(rs.getString("picture"));
				suppliers.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliers;
	}

}