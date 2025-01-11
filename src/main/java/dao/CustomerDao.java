package dao;

import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectDB;
import entity.CustomerEntity;

public class CustomerDao {

	// ... (Các phương thức khác) ...

	public CustomerEntity findCustomerByPhoneNumber(String phoneNumber) {
		var sql = "SELECT * FROM Customers WHERE phone_number = ?";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, phoneNumber);

			try (var rs = stmt.executeQuery()) {
				if (rs.next()) {
					// Tạo đối tượng CustomerEntity từ ResultSet
					return new CustomerEntity(rs.getInt("id"), rs.getString("full_name"), rs.getString("phone_number"),
							rs.getString("email"), rs.getString("address"), rs.getBoolean("isDelete"),
							rs.getString("picture"), rs.getDate("date_of_birth").toLocalDate(),
							rs.getString("customer_type"), rs.getInt("points"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
		return null; // Trả về null nếu không tìm thấy khách hàng
	}

	public int insertCustomer(CustomerEntity customer) {
		var sql = "INSERT INTO Customers (full_name, phone_number, email, address, isDelete, picture, date_of_birth, customer_type, points) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Thêm
																													// Statement.RETURN_GENERATED_KEYS
																													// để
																													// lấy
																													// id

			// Gán giá trị cho các tham số
			stmt.setString(1, customer.getFull_name());
			stmt.setString(2, customer.getPhone_number());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getAddress());
			stmt.setBoolean(5, customer.isDelete());
			stmt.setString(6, customer.getPicture());
			if (customer.getDate_of_birth() != null) {
				stmt.setDate(7, java.sql.Date.valueOf(customer.getDate_of_birth()));
			} else {
				stmt.setNull(7, java.sql.Types.DATE); // Set giá trị null cho cột date_of_birth
			}
			stmt.setString(8, customer.getCustomer_type());
			stmt.setInt(9, customer.getPoints());

			stmt.executeUpdate();

			// Lấy id của khách hàng vừa tạo
			try (var generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi
		}
		return -1; // Trả về -1 nếu có lỗi
	}
}