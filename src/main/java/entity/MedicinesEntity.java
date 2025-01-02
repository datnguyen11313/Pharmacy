package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicinesEntity {
	private int id;
	private String medicine_name;
	public CategoriesEntity category;
	private BigDecimal price;
	private int stock;
	private LocalDate manufacturing_date;
	private LocalDate expiry_date;
	private String picture;

	private boolean isDelete;
	public SupplierEntity supplier;
	private String unit;
	private String concentration;
	private String usage;
	private String contraindications;
	private String side_effects;
	private String storage;
	private String ingredients;

	public MedicinesEntity() {

	}

	public MedicinesEntity(int id, String medicine_name, CategoriesEntity category, BigDecimal price, int stock,
			LocalDate manufacturing_date, LocalDate expiry_date, String picture, boolean isDelete,
			SupplierEntity supplier, String unit, String concentration, String usage, String contraindications,
			String side_effects, String storage, String ingredients) {
		super();
		this.id = id;
		this.medicine_name = medicine_name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.manufacturing_date = manufacturing_date;
		this.expiry_date = expiry_date;
		this.picture = picture;
		this.isDelete = isDelete;
		this.supplier = supplier;
		this.unit = unit;
		this.concentration = concentration;
		this.usage = usage;
		this.contraindications = contraindications;
		this.side_effects = side_effects;
		this.storage = storage;
		this.ingredients = ingredients;
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

	public CategoriesEntity getCategory() {
		return category;
	}

	public void setCategory(CategoriesEntity category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getContraindications() {
		return contraindications;
	}

	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}

	public String getSide_effects() {
		return side_effects;
	}

	public void setSide_effects(String side_effects) {
		this.side_effects = side_effects;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "MedicinesEntity [id=" + id + ", medicine_name=" + medicine_name + ", category=" + category + ", price="
				+ price + ", stock=" + stock + ", manufacturing_date=" + manufacturing_date + ", expiry_date="
				+ expiry_date + ", picture=" + picture + ", isDelete=" + isDelete + ", supplier=" + supplier + ", unit="
				+ unit + ", concentration=" + concentration + ", usage=" + usage + ", contraindications="
				+ contraindications + ", side_effects=" + side_effects + ", storage=" + storage + ", ingredients="
				+ ingredients + "]";
	}

}
