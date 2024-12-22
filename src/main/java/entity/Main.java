package entity;

public class Main {
	private int id;
	private String medicine_name;
	private int category_id;
	private int price;
	private int stock;

	public Main() {

	}

	public Main(int id, String medicine_name, int category_id, int price, int stock) {
		super();
		this.id = id;
		this.medicine_name = medicine_name;
		this.category_id = category_id;
		this.price = price;
		this.stock = stock;
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

	@Override
	public String toString() {
		return "Main [id=" + id + ", medicine_name=" + medicine_name + ", category_id=" + category_id + ", price="
				+ price + ", stock=" + stock + "]";
	}

}
