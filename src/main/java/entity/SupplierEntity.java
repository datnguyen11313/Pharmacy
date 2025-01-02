package entity;

public class SupplierEntity {

	private int id;
	private String supplier_name;
	private String contact_phone;
	private String contact_email;
	private String address;
	private boolean isDelete;
	private String picture;

	public SupplierEntity() {

	}

	public SupplierEntity(int id, String supplier_name, String contact_phone, String contact_email, String address,
			boolean isDelete, String picture) {
		super();
		this.id = id;
		this.supplier_name = supplier_name;
		this.contact_phone = contact_phone;
		this.contact_email = contact_email;
		this.address = address;
		this.isDelete = isDelete;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
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

	@Override
	public String toString() {
		return "SupplierEntity [id=" + id + ", supplier_name=" + supplier_name + ", contact_phone=" + contact_phone
				+ ", contact_email=" + contact_email + ", address=" + address + ", isDelete=" + isDelete + ", picture="
				+ picture + "]";
	}

}
