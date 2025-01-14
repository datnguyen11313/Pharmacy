package entity;

import java.util.Date;

public class EmployeeEntity {
	private int id;
	private String fullName;
	private String phoneNumber;
	private String email;
	private String address;
	private String identityCard;
	private String picture;
	private Date createdAt;
	private Date updatedAt;
	private boolean isDelete;
	private int role_id;
	private double salary;
	private Date startDate;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(int id, String fullName, String phoneNumber, String email, String address,
			String identityCard, String picture, Date createdAt, Date updatedAt, boolean isDelete, int role_id,
			double salary, Date startDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.identityCard = identityCard;
		this.picture = picture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDelete = isDelete;
		this.role_id = role_id;
		this.salary = salary;
		this.startDate = startDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public int getRoleID() {
		return role_id;
	}

	public void setRoleID(int role_id) {
		this.role_id = role_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", address=" + address + ", identityCard=" + identityCard + ", picture=" + picture
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isDelete=" + isDelete + ", role="
				+ role_id + ", salary=" + salary + ", startDate=" + startDate + "]";
	}
}