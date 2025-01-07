package entity;

import java.sql.Date;

public class InventoryStatistics {
	private int medicineId;
	private String medicineName;
	private String medicineCategory;
	private int inventoryAmount;
	private Date expiredDate;

	public InventoryStatistics() {

	}

	public InventoryStatistics(int medicineId, String medicineName, String medicineCategory, int inventoryAmount,
			Date expiredDate) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineCategory = medicineCategory;
		this.inventoryAmount = inventoryAmount;
		this.expiredDate = expiredDate;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(String medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date date) {
		this.expiredDate = date;
	}

	@Override
	public String toString() {
		return "InventoryStatistics [medicineId=" + medicineId + ", medicineName=" + medicineName
				+ ", medicineCategory=" + medicineCategory + ", inventoryAmount=" + inventoryAmount + ", expiredDate="
				+ expiredDate + "]";
	}

}
