package dao;

import java.sql.SQLException;

import database.ConnectDB;
import entity.InvoiceEntity;

public class InvoiceDao {

	public void insertInvoice(InvoiceEntity invoice) {
		var sql = "INSERT INTO invoices ( order_id, invoice_date, total_amount, amount_paid, payment_status, isDelete, picture, customer_name, customer_address, customer_phone,customer_type) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (var con = ConnectDB.getCon(); var stmt = con.prepareStatement(sql)) {

			// Gán giá trị cho các tham số trong câu truy vấn

			stmt.setString(1, invoice.getOrder_id());
			stmt.setDate(2, java.sql.Date.valueOf(invoice.getInvoice_date()));
			stmt.setBigDecimal(3, invoice.getTotal_amount());
			stmt.setBigDecimal(4, invoice.getAmount_paid());
			stmt.setBoolean(5, invoice.isPayment_status());
			stmt.setBoolean(6, invoice.isDelete());
			stmt.setString(7, invoice.getPicture());
			stmt.setString(8, invoice.getCustomer_name());
			stmt.setString(9, invoice.getCustomer_address());
			stmt.setString(10, invoice.getCustomer_phone());
			stmt.setString(11, invoice.getCustomer_type()); // Gán giá trị cho tham số thứ 11

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
		}
	}

	// ... các phương thức khác ...
}