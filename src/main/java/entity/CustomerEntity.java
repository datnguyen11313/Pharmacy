package entity;

import java.time.LocalDate;

public class CustomerEntity {
	private int id;
	private String full_name;
	private String phone_number;
	private String email;
	private String address;
	private boolean isDelete;
	private String picture;
	private LocalDate date_of_birth;
	private String customer_type;
	private int points;

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(int id, String full_name, String phone_number, String email, String address, boolean isDelete,
			String picture, LocalDate date_of_birth, String customer_type, int points) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.phone_number = phone_number;
		this.email = email;
		this.address = address;
		this.isDelete = isDelete;
		this.picture = picture;
		this.date_of_birth = date_of_birth;
		this.customer_type = customer_type;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", full_name=" + full_name + ", phone_number=" + phone_number + ", email="
				+ email + ", address=" + address + ", isDelete=" + isDelete + ", picture=" + picture
				+ ", date_of_birth=" + date_of_birth + ", customer_type=" + customer_type + ", points=" + points + "]";
	}

}
