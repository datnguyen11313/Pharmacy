package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.CustomerEntity;

public class CustomerDAO {
	// Phương thức lấy tất cả khách hàng
	public List<CustomerEntity> getAllCustomers() {
		var sql = "SELECT id, full_name, phone_number, email, address, created_at, updated_at, picture, date_of_birth, customer_type, points FROM customers WHERE isDelete = 0";
		List<CustomerEntity> customers = new ArrayList<>();

		try (var conn = ConnectDB.getCon(); var stmt = conn.prepareStatement(sql); var rs = stmt.executeQuery()) {
			while (rs.next()) {
				var customer = new CustomerEntity();
				customer.setId(rs.getInt("id"));
				customer.setFull_name(rs.getString("full_name"));
				customer.setPhone_number(rs.getString("phone_number"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress(rs.getString("address"));
				customer.setCreatedAt(rs.getDate("created_at"));
				customer.setUpdatedAt(rs.getDate("updated_at"));
				customer.setPicture(rs.getString("picture"));
				customer.setDateOfBirth(rs.getDate("date_of_birth"));
				customer.setCustomerType(rs.getString("customer_type"));
				customer.setPoints(rs.getInt("points"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Failed to fetch customers", e);
		}
		return customers;
	}

	public boolean addCustomer(CustomerEntity customer) {
		var sql = "INSERT INTO customers (full_name, phone_number, email, address, created_at, updated_at, isDelete, picture, date_of_birth, customer_type, points) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (var conn = ConnectDB.getCon(); var pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFull_name());
			pstmt.setString(2, customer.getPhone_number());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getAddress());
			pstmt.setDate(5, new java.sql.Date(customer.getCreatedAt().getTime()));
			pstmt.setDate(6, new java.sql.Date(customer.getUpdatedAt().getTime()));
			pstmt.setBoolean(7, false);
			pstmt.setString(8, customer.getPicture());
			pstmt.setDate(9, new java.sql.Date(customer.getDateOfBirth().getTime())); // Sửa chỉ mục từ 6 thành 9
			pstmt.setString(10, customer.getCustomerType());
			pstmt.setInt(11, customer.getPoints());

			var rowsAffected = pstmt.executeUpdate(); // executeUpdate() không trả về ResultSet
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCustomer(CustomerEntity customer) {
		var sql = "UPDATE customers SET full_name = ?, phone_number = ?, email = ?, address = ?, updated_at = ?, picture = ?, date_of_birth = ?, customer_type = ?, points = ? WHERE id = ?";
		try (var conn = ConnectDB.getCon(); var pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFull_name());
			pstmt.setString(2, customer.getPhone_number());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getAddress());
			pstmt.setDate(5, new java.sql.Date(customer.getUpdatedAt().getTime()));
			pstmt.setString(6, customer.getPicture());
			pstmt.setDate(7, new java.sql.Date(customer.getDateOfBirth().getTime())); // Đổi chỉ mục thành 7
			pstmt.setString(8, customer.getCustomerType());
			pstmt.setInt(9, customer.getPoints());
			pstmt.setInt(10, customer.getId());

			var rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCustomerById(int customerId) {
		var sql = "UPDATE customers SET isDelete = 1 WHERE id = ?";
		try (var conn = ConnectDB.getCon(); var pstmt = conn.prepareStatement(sql)) { // Không cần 'rs' ở đây
			pstmt.setInt(1, customerId); // Đảm bảo tham số được thiết lập đúng

			var rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate để thực thi câu lệnh UPDATE
			return rowsAffected > 0; // Nếu có dòng bị ảnh hưởng thì trả về true
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<CustomerEntity> searchCustomersByName(String name) {
		var customers = new ArrayList<CustomerEntity>();
		var sql = """
				    SELECT id, full_name, phone_number, email, address, created_at, updated_at, picture, date_of_birth, customer_type, points FROM customers
				    WHERE isDelete = 0
				    AND full_name LIKE ?
				    ORDER BY created_at DESC
				""";

		try (var conn = ConnectDB.getCon(); var pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + name + "%");
			try (var rs = pstmt.executeQuery()) {
				while (rs.next()) {
					var customer = new CustomerEntity();
					customer.setId(rs.getInt("id"));
					customer.setFull_name(rs.getString("full_name"));
					customer.setPhone_number(rs.getString("phone_number"));
					customer.setEmail(rs.getString("email"));
					customer.setAddress(rs.getString("address"));
					customer.setDateOfBirth(rs.getDate("date_of_birth"));
					customer.setCustomerType(rs.getString("customer_type"));
					customer.setPoints(rs.getInt("points"));
					customer.setCreatedAt(rs.getDate("created_at"));
					customer.setUpdatedAt(rs.getDate("updated_at"));
					customer.setPicture(rs.getString("picture"));

					customers.add(customer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

}
