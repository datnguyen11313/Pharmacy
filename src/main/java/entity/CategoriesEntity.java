package entity;

public class CategoriesEntity {
	private int id;
	private String caterogy_name;
	private boolean isDelete;
	private String picture;
	public CategoriesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriesEntity(int id, String caterogy_name, boolean isDelete, String picture) {
		super();
		this.id = id;
		this.caterogy_name = caterogy_name;
		this.isDelete = isDelete;
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaterogy_name() {
		return caterogy_name;
	}
	public void setCaterogy_name(String caterogy_name) {
		this.caterogy_name = caterogy_name;
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
		return "CategoriesEntity [id=" + id + ", caterogy_name=" + caterogy_name + ", isDelete=" + isDelete
				+ ", picture=" + picture + "]";
	}
	
	
}
