package entity;

import java.math.BigDecimal;

public class OrderDetailEntity {
	private int id;
	private String order_id;
	private int medicine_id;
	private int quantity;
	private BigDecimal unit_price;
	private BigDecimal total_price;
	private boolean isDelete;

	public OrderDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailEntity(int id, String order_id, int medicine_id, int quantity, BigDecimal unit_price,
			BigDecimal total_price, boolean isDelete) {

		this.id = id;
		this.order_id = order_id;
		this.medicine_id = medicine_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.total_price = total_price;
		this.isDelete = isDelete;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "OrderDetailEntity [id=" + id + ", order_id=" + order_id + ", medicine_id=" + medicine_id + ", quantity="
				+ quantity + ", unit_price=" + unit_price + ", total_price=" + total_price + ", isDelete=" + isDelete
				+ "]";
	}

}
