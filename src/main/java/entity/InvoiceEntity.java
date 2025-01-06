package entity;

import java.time.LocalDate;

public class InvoiceEntity {
	private int id;
	private int order_id;
	private LocalDate invoice_date;
	private int total_amount;
	private int amount_paid;
	private boolean payment_status;
	private boolean isDelete;
	private String picture;
	private String customer_name;
	private String customer_address;
	private String customer_phone;
	
	public InvoiceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceEntity(int id, int order_id, LocalDate invoice_date, int total_amount, int amount_paid,
			boolean payment_status, boolean isDelete, String picture, String customer_name, String customer_address,
			String customer_phone) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.invoice_date = invoice_date;
		this.total_amount = total_amount;
		this.amount_paid = amount_paid;
		this.payment_status = payment_status;
		this.isDelete = isDelete;
		this.picture = picture;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public LocalDate getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(LocalDate invoice_date) {
		this.invoice_date = invoice_date;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public int getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(int amount_paid) {
		this.amount_paid = amount_paid;
	}
	public boolean isPayment_status() {
		return payment_status;
	}
	public void setPayment_status(boolean payment_status) {
		this.payment_status = payment_status;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	@Override
	public String toString() {
		return "InvoiceEntity [id=" + id + ", order_id=" + order_id + ", invoice_date=" + invoice_date
				+ ", total_amount=" + total_amount + ", amount_paid=" + amount_paid + ", payment_status="
				+ payment_status + ", isDelete=" + isDelete + ", picture=" + picture + ", customer_name="
				+ customer_name + ", customer_address=" + customer_address + ", customer_phone=" + customer_phone + "]";
	}
	
	
}
