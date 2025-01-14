package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.EmployeeEntity;

public class EmployeeDAO {
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employees = new ArrayList<>();
		var sql = "SELECT id, full_name, phone_number, email, address, identity_card, picture, created_at, updated_at, isDelete, role, salary, start_date FROM employee WHERE isDelete = 0";

		try (var conn = ConnectDB.getCon(); var stmt = conn.prepareStatement(sql); var rs = stmt.executeQuery()) {

			while (rs.next()) {
				var employee = new EmployeeEntity();
				employee.setId(rs.getInt("id"));
				employee.setFullName(rs.getString("full_name"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setIdentityCard(rs.getString("identity_card"));
				employee.setPicture(rs.getString("picture"));
				employee.setCreatedAt(rs.getDate("created_at"));
				employee.setUpdatedAt(rs.getDate("updated_at"));
				employee.setDelete(rs.getBoolean("isDelete"));
				employee.setRoleID(rs.getInt("role"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setStartDate(rs.getDate("start_date"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Failed to fetch employees", e);
		}
		return employees;
	}

	public boolean addEmployee(EmployeeEntity employee) {
		var sql = """
				INSERT INTO employee (full_name, phone_number, email, address, identity_card, picture, salary, \
				start_date, created_at, updated_at, isDelete, role) \
				VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";

		try (var conn = ConnectDB.getCon(); var pstmt = conn.prepareStatement(sql)) {

			// Gán giá trị vào câu lệnh SQL
			pstmt.setString(1, employee.getFullName());
			pstmt.setString(2, employee.getPhoneNumber());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getAddress());
			pstmt.setString(5, employee.getIdentityCard());
			pstmt.setString(6, employee.getPicture());
			pstmt.setDouble(7, employee.getSalary());
			pstmt.setDate(8, new java.sql.Date(employee.getStartDate().getTime()));
			pstmt.setDate(9, new java.sql.Date(employee.getCreatedAt().getTime()));
			pstmt.setDate(10, new java.sql.Date(employee.getUpdatedAt().getTime()));
			pstmt.setBoolean(11, false); // Thay thế 'false' bằng cách truyền giá trị trực tiếp
			pstmt.setInt(12, employee.getRoleID());

			// Thực thi câu lệnh
			return pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmployee(EmployeeEntity employee) {
		var query = "UPDATE employee SET full_name = ?, phone_number = ?, email = ?, address = ?, identity_card = ?, "
				+ "picture = ?, updated_at = ?, isDelete = ?, role = ?, salary = ?, start_date = ? WHERE id = ?";
		try (var conn = ConnectDB.getCon(); var stmt = conn.prepareStatement(query)) {

			stmt.setString(1, employee.getFullName());
			stmt.setString(2, employee.getPhoneNumber());
			stmt.setString(3, employee.getEmail());
			stmt.setString(4, employee.getAddress());
			stmt.setString(5, employee.getIdentityCard());
			stmt.setString(6, employee.getPicture()); // Nếu có thể để null, cần kiểm tra tại đây
			stmt.setTimestamp(7, new java.sql.Timestamp(employee.getUpdatedAt().getTime())); // Cập nhật thời gian hiện
																								// tại
			stmt.setBoolean(8, employee.isDelete());
			stmt.setInt(9, employee.getRoleID());
			stmt.setDouble(10, employee.getSalary());
			stmt.setDate(11, new java.sql.Date(employee.getStartDate().getTime()));
			stmt.setInt(12, employee.getId());

			var rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmployeeById(int employeeId) {
		var query = "UPDATE employees SET isDelete = 1, updated_at = GETDATE() WHERE id = ?";
		try (var conn = ConnectDB.getCon(); var stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, employeeId);

			var rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0; // Trả về true nếu cập nhật thành công
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<EmployeeEntity> searchEmployeesByName(String name) {
		var employees = new ArrayList<EmployeeEntity>();
		var sql = """
				    SELECT id, full_name, phone_number, email, address, identity_card, picture, created_at, updated_at, isDelete, role, salary, start_date FROM employee
				    WHERE isDelete = 0
				    AND full_name LIKE ?
				    ORDER BY created_at DESC
				""";

		try (var conn = ConnectDB.getCon(); var pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + name + "%");
			try (var rs = pstmt.executeQuery()) {
				while (rs.next()) {
					var emp = new EmployeeEntity();
					emp.setId(rs.getInt("id"));
					emp.setFullName(rs.getString("full_name"));
					emp.setPhoneNumber(rs.getString("phone_number"));
					emp.setEmail(rs.getString("email"));
					emp.setAddress(rs.getString("address"));
					emp.setIdentityCard(rs.getString("identity_card"));
					emp.setPicture(rs.getString("picture"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setStartDate(rs.getDate("start_date"));
					emp.setCreatedAt(rs.getDate("created_at"));
					emp.setUpdatedAt(rs.getDate("updated_at"));
					emp.setDelete(rs.getBoolean("isDelete"));
					emp.setRoleID(rs.getInt("role"));

					employees.add(emp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
