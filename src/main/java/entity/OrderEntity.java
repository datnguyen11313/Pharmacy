package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderEntity {
    private int id;
	private int user_id;
	private String customer_name;
	private BigDecimal total_price;
	private LocalDate order_date;
	private boolean isDelete;
	private int customer_id;
	private int employee_id;
	private String picture;
	private String payment_method;
	private boolean status;
	private String notes;
	
	
	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderEntity(int id, int user_id, String customer_name, BigDecimal total_price, LocalDate order_date,
			boolean isDelete, int customer_id, int employee_id, String picture, String payment_method, boolean status,
			String notes) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.customer_name = customer_name;
		this.total_price = total_price;
		this.order_date = order_date;
		this.isDelete = isDelete;
		this.customer_id = customer_id;
		this.employee_id = employee_id;
		this.picture = picture;
		this.payment_method = payment_method;
		this.status = status;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", user_id=" + user_id + ", customer_name=" + customer_name + ", total_price="
				+ total_price + ", order_date=" + order_date + ", isDelete=" + isDelete + ", customer_id=" + customer_id
				+ ", employee_id=" + employee_id + ", picture=" + picture + ", payment_method=" + payment_method
				+ ", status=" + status + ", notes=" + notes + ", getId()=" + getId() + ", getUser_id()=" + getUser_id()
				+ ", getCustomer_name()=" + getCustomer_name() + ", getTotal_price()=" + getTotal_price()
				+ ", getOrder_date()=" + getOrder_date() + ", isDelete()=" + isDelete() + ", getCustomer_id()="
				+ getCustomer_id() + ", getEmployee_id()=" + getEmployee_id() + ", getPicture()=" + getPicture()
				+ ", getPayment_method()=" + getPayment_method() + ", isStatus()=" + isStatus() + ", getNotes()="
				+ getNotes() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
