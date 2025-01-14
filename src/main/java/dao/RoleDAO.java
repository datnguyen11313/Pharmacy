package dao;

import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.RoleEntity;

public class RoleDAO {
	public List<RoleEntity> getEmployeeRoles() {
		List<RoleEntity> roles = new ArrayList<>();
		var sql = "SELECT id, role_name FROM Roles";

		try (var conn = ConnectDB.getCon(); var stmt = conn.prepareStatement(sql); var rs = stmt.executeQuery()) {

			while (rs.next()) {
				var role = new RoleEntity();
				role.setId(rs.getInt("id"));
				role.setRole_name(rs.getString("role_name"));
				roles.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roles;
	}
}
