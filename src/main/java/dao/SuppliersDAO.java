package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.ConnectDB;

public class SuppliersDAO {
	public List<Map.Entry<Integer, String>> getAllSuppliers() {
		List<Map.Entry<Integer, String>> suppliers = new ArrayList<>();
		String query = "SELECT id, supplier_name FROM suppliers";

		try (Connection con = ConnectDB.getCon();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("supplier_name");
				suppliers.add(new AbstractMap.SimpleEntry<>(id, name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return suppliers;
	}

}
