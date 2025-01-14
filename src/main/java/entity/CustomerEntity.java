package entity;

import java.util.Date;

public class CustomerEntity {
	private int id;
	private String full_name;
	private String phone_number;
	private String email;
	private String address;
	private Date createdAt;
	private Date updatedAt;
	private boolean isDelete;
	private String picture;
	private Date dateOfBirth;
	private String customerType;
	private int points;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(int id, String full_name, String phone_number, String email, String address, Date createdAt,
			Date updatedAt, boolean isDelete, String picture, Date dateOfBirth, String customerType, int points) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.phone_number = phone_number;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDelete = isDelete;
		this.picture = picture;
		this.dateOfBirth = dateOfBirth;
		this.customerType = customerType;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "CustomersEntity [id=" + id + ", full_name=" + full_name + ", phone_number=" + phone_number + ", email="
				+ email + ", address=" + address + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", isDelete=" + isDelete + ", picture=" + picture + ", dateOfBirth=" + dateOfBirth + ", customerType="
				+ customerType + ", points=" + points + "]";
	}

}