package dao;

import java.sql.SQLException;

import database.ConnectDB;
import entity.OrderDetailEntity;

public class OrderDetailDao {
	public void insertOrderDetail(OrderDetailEntity orderDetail) {
		var sql = "INSERT INTO order_details (order_id, medicine_id, quantity, unit_price, total_price, isDelete) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			// Gán giá trị cho các tham số trong câu truy vấn
			stmt.setString(1, orderDetail.getOrder_id());
			stmt.setInt(2, orderDetail.getMedicine_id());
			stmt.setInt(3, orderDetail.getQuantity());
			stmt.setBigDecimal(4, orderDetail.getUnit_price());
			stmt.setBigDecimal(5, orderDetail.getTotal_price());
			stmt.setBoolean(6, orderDetail.isDelete());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
	}
}
