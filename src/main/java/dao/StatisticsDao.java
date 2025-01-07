package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.BestSellingProductsStatistics;
import entity.InventoryStatistics;
import entity.RevenueStatistics;

public class StatisticsDao {
	// thống kê doanh thu theo ngày từ ngày nào đến ngày nào theo style của thầy
	// Nguyên
	public List<RevenueStatistics> revenueStatistics(LocalDate fromdate, LocalDate todate) {
		List<RevenueStatistics> list = new ArrayList<>();
		try (var con = ConnectDB.getCon(); var cs = con.prepareCall("{call revenueStatistics(?, ?)}");) {
			cs.setDate(1, java.sql.Date.valueOf(fromdate));
			cs.setDate(2, java.sql.Date.valueOf(todate));
			var rs = cs.executeQuery();
			while (rs.next()) {
				var revenue = new RevenueStatistics();
				revenue.setOrder_date(rs.getDate("order_date"));
				revenue.setTotalRevenue(rs.getDouble("totalRevenue"));
				revenue.setTotalOrders(rs.getInt("totalOrder"));
				list.add(revenue);
			}

			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Không có dữ liệu nào trong khoảng thời gian từ " + fromdate + " đến " + todate, "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// thống kê tồn kho theo ngày hết hạn
	public List<InventoryStatistics> inventoryStatistics(LocalDate fromdate, LocalDate todate) {
		List<InventoryStatistics> list = new ArrayList<>();
		try (var con = ConnectDB.getCon(); var cs = con.prepareCall("{call inventoryStatistics(?,?)}");) {
			cs.setDate(1, java.sql.Date.valueOf(fromdate));
			cs.setDate(2, java.sql.Date.valueOf(todate));
			var rs = cs.executeQuery();
			while (rs.next()) {
				var inventory = new InventoryStatistics();
				inventory.setMedicineId(rs.getInt("medicineId"));
				inventory.setMedicineName(rs.getString("medicineName"));
				inventory.setMedicineCategory(rs.getString("medicineCategory"));
				inventory.setInventoryAmount(rs.getInt("inventoryAmount"));
				inventory.setExpiredDate(rs.getDate("expiredDate"));
				list.add(inventory);
			}
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Không có dữ liệu nào trong khoảng thời gian từ " + fromdate + " đến " + todate, "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// thống kê 10 sản phẩm bán chạy nhất
	public List<BestSellingProductsStatistics> bestSellingProductsStatistics(LocalDate fromdate, LocalDate todate) {
		List<BestSellingProductsStatistics> list = new ArrayList<>();
		try (var con = ConnectDB.getCon(); var cs = con.prepareCall("{call bestSellingProductsStatistics(?, ?)}");) {
			cs.setDate(1, java.sql.Date.valueOf(fromdate));
			cs.setDate(2, java.sql.Date.valueOf(todate));
			var rs = cs.executeQuery();
			while (rs.next()) {
				var bestSelling = new BestSellingProductsStatistics();
				bestSelling.setMedicineId(rs.getInt("medicineId"));
				bestSelling.setMedicineName(rs.getString("medicineName"));
				bestSelling.setTotalSellingAmount(rs.getInt("totalSellingAmount"));
				bestSelling.setTotalRevenue(rs.getDouble("totalRevenue"));
				list.add(bestSelling);
			}
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Không có dữ liệu nào trong khoảng thời gian từ " + fromdate + " đến " + todate, "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
