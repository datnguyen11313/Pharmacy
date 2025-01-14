package entity;

import java.util.Date;

public class RoleEntity {
	private int id;
	private String role_name;
	private Date createdAt;
	private Date updatedAt;
	private boolean isDelete;
	private String picture;

	public RoleEntity() {
		super();
	}

	public RoleEntity(int id, String role_name, Date createdAt, Date updatedAt, boolean isDelete, String picture) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDelete = isDelete;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", role_name=" + role_name + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", isDelete=" + isDelete + ", picture=" + picture + "]";
	}
}
