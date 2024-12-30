package entity;

import java.time.LocalDate;

public class MedicinesEntity {
	private int id;
	private String medicine_name;
	private int category_id;
	private int price;
	private int stock;
	private LocalDate manufacturing_date;
	private LocalDate expiry_date;
	private boolean isDelete;
	private String picture;

	public MedicinesEntity() {
		super();

	}

	public MedicinesEntity(int id, String medicine_name, int category_id, int price, int stock,
			LocalDate manufacturing_date, LocalDate expiry_date, boolean isDelete, String picture) {
		super();
		this.id = id;
		this.medicine_name = medicine_name;
		this.category_id = category_id;
		this.price = price;
		this.stock = stock;
		this.manufacturing_date = manufacturing_date;
		this.expiry_date = expiry_date;
		this.isDelete = isDelete;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getManufacturing_date() {
		return manufacturing_date;
	}

	public void setManufacturing_date(LocalDate manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
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

	@Override
	public String toString() {
		return "MedicinesEntity [id=" + id + ", medicine_name=" + medicine_name + ", category_id=" + category_id
				+ ", price=" + price + ", stock=" + stock + ", manufacturing_date=" + manufacturing_date
				+ ", expiry_date=" + expiry_date + ", isDelete=" + isDelete + ", picture=" + picture + "]";
	}

}
