package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.ConnectDB;
import entity.OrderEntity;
public class OrderDao {

	public String getLastOrderId() {
        String sql = "SELECT MAX(id) FROM Orders"; // Lấy mã order lớn nhất
        try (Connection con = ConnectDB.getCon();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
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
	        String sql = "SELECT MAX(CAST(SUBSTRING(id, 9, 4) AS UNSIGNED)) FROM Orders WHERE id LIKE ?"; // Lấy số thứ tự lớn nhất trong ngày
	        try (Connection con = ConnectDB.getCon();
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setString(1, "OD" + datePart + "%");
	            try (ResultSet rs = stmt.executeQuery()) {
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
	        String sql = "INSERT INTO Orders (id, user_id, customer_name, total_price, order_date, isDelete, customer_id, employee_id, picture, payment_method, status, notes) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (Connection con = ConnectDB.getCon();
	             PreparedStatement stmt = con.prepareStatement(sql)) {

	            // Gán giá trị cho các tham số trong câu truy vấn
	            stmt.setInt(1, order.getId());
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
}
