package entity;

public class BestSellingProductsStatistics {
	private int medicineId;
	private String medicineName;
	private int totalSellingAmount;
	private double totalRevenue;

	public BestSellingProductsStatistics() {

	}

	public BestSellingProductsStatistics(int medicineId, String medicineName, int totalSellingAmount,
			double totalRevenue) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.totalSellingAmount = totalSellingAmount;
		this.totalRevenue = totalRevenue;
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

	public int getTotalSellingAmount() {
		return totalSellingAmount;
	}

	public void setTotalSellingAmount(int totalSellingAmount) {
		this.totalSellingAmount = totalSellingAmount;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	@Override
	public String toString() {
		return "BestSellingProductsStatistics [medicineId=" + medicineId + ", medicineName=" + medicineName
				+ ", totalSellingAmount=" + totalSellingAmount + ", totalRevenue=" + totalRevenue + "]";
	}

}
