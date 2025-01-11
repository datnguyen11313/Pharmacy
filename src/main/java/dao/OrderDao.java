package dao;

import java.sql.SQLException;

import database.ConnectDB;
import entity.OrderEntity;

public class OrderDao {

	public String getLastOrderId() {
		var sql = "SELECT MAX(id) FROM Orders"; // Lấy mã order lớn nhất
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql); var rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
		return null; // Hoặc trả về một giá trị mặc định nếu không tìm thấy
	}

	public int getLastOrderNumberForDate(String datePart) {
		var sql = "SELECT MAX(ABS(CAST(SUBSTRING(CONVERT(varchar, id), 9, 4) AS int))) FROM Orders WHERE id LIKE ?"; // Lấy
																														// số
																														// thứ
																														// tự
																														// lớn
																														// nhất
																														// trong
																														// ngày
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "OD" + datePart + "%");
			try (var rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi
		}
		return 0; // Hoặc trả về một giá trị mặc định
	}

	public void insertOrder(OrderEntity order) {
		var sql = "INSERT INTO Orders (id, user_id, customer_name, total_price, order_date, isDelete, customer_id, employee_id, picture, payment_method, status, notes) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			// Gán giá trị cho các tham số trong câu truy vấn
			stmt.setString(1, order.getId());
			stmt.setInt(2, order.getUser_id());
			stmt.setString(3, order.getCustomer_name());
			stmt.setBigDecimal(4, order.getTotal_price());
			stmt.setDate(5, java.sql.Date.valueOf(order.getOrder_date()));
			stmt.setBoolean(6, order.isDelete());
			stmt.setInt(7, order.getCustomer_id());
			stmt.setInt(8, order.getEmployee_id());
			stmt.setString(9, order.getPicture());
			stmt.setString(10, order.getPayment_method());
			stmt.setBoolean(11, order.isStatus());
			stmt.setString(12, order.getNotes());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
	}

	public void updateOrderStatus(String orderId, boolean status) {
		var sql = "UPDATE Orders SET status = ? WHERE id = ?";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			stmt.setBoolean(1, status);
			stmt.setString(2, orderId);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
	}

	public boolean updateOrder(OrderEntity order) {
		var sql = """
				UPDATE Orders SET \
				user_id = ?, \
				customer_name = ?, \
				total_price = ?, \
				isDelete = ?, \
				customer_id = ?, \
				employee_id = ?, \
				picture = ?, \
				payment_method = ?, \
				status = ?, \
				notes = ? \
				WHERE id = ?""";

		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, order.getUser_id());
			stmt.setString(2, order.getCustomer_name());
			stmt.setBigDecimal(3, order.getTotal_price());
			stmt.setBoolean(4, order.isDelete());
			stmt.setInt(5, order.getCustomer_id());
			stmt.setInt(6, order.getEmployee_id());
			stmt.setString(7, order.getPicture());
			stmt.setString(8, order.getPayment_method());
			stmt.setBoolean(9, order.isStatus());
			stmt.setString(10, order.getNotes());
			stmt.setString(11, order.getId());

			var rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi
			return false;
		}
	}

	public OrderEntity getOrderByID(String orderId) {
		var sql = "SELECT * FROM Orders WHERE id = ?";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, orderId);

			try (var rs = stmt.executeQuery()) {
				if (rs.next()) {
					// Tạo đối tượng OrderEntity từ ResultSet
					return new OrderEntity(rs.getString("id"), rs.getInt("user_id"), rs.getString("customer_name"),
							rs.getBigDecimal("total_price"), rs.getDate("order_date").toLocalDate(),
							rs.getBoolean("isDelete"), rs.getInt("customer_id"), rs.getInt("employee_id"),
							rs.getString("picture"), rs.getString("payment_method"), rs.getBoolean("status"),
							rs.getString("notes"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
		return null; // Trả về null nếu không tìm thấy Order
	}
}
