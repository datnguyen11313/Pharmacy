package entity;

import java.sql.Date;

public class RevenueStatistics {
	private Date order_date;
	private Double totalRevenue;
	private int totalOrder;

	public RevenueStatistics() {

	}

	public RevenueStatistics(Date order_date, Double totalRevenue, int totalOrder) {
		super();
		this.order_date = order_date;
		this.totalRevenue = totalRevenue;
		this.totalOrder = totalOrder;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date date) {
		this.order_date = date;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public int getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrders(int totalOrder) {
		this.totalOrder = totalOrder;
	}

	@Override
	public String toString() {
		return "RevenueStatistics [order_date=" + order_date + ", totalRevenue=" + totalRevenue + ", totalOrder="
				+ totalOrder + "]";
	}

}
