package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.ConnectDB;
import entity.InvoiceEntity;

public class InvoiceDao {
    
    public void insertInvoice(InvoiceEntity invoice) {
        String sql = "INSERT INTO Invoices (id, order_id, invoice_date, total_amount, amount_paid, payment_status, isDelete, picture, customer_name, customer_address, customer_phone) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectDB.getCon();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Gán giá trị cho các tham số trong câu truy vấn
            stmt.setInt(1, invoice.getId());
            stmt.setInt(2, invoice.getOrder_id());
            stmt.setDate(3, java.sql.Date.valueOf(invoice.getInvoice_date()));
            stmt.setInt(4, invoice.getTotal_amount());
            stmt.setInt(5, invoice.getAmount_paid());
            stmt.setBoolean(6, invoice.isPayment_status());
            stmt.setBoolean(7, invoice.isDelete());
            stmt.setString(8, invoice.getPicture());
            stmt.setString(9, invoice.getCustomer_name());
            stmt.setString(10, invoice.getCustomer_address());
            stmt.setString(11, invoice.getCustomer_phone());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi, ví dụ: ghi log, thông báo lỗi,...
        }
    }

    // ... các phương thức khác ...
}