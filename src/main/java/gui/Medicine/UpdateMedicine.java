package gui.Medicine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MedicinesDao;
import entity.MedicinesEntity;

public class UpdateMedicine extends JFrame {
	private final JTextField txtName = new JTextField(20);
	private final JTextField txtPrice = new JTextField(20);
	private final JTextField txtStock = new JTextField(20);
	private final JComboBox<String> cbCategory = new JComboBox<>();
	private final JTextField txtManufacturingDate = new JTextField(20);
	private final JTextField txtExpiryDate = new JTextField(20);
	private final JComboBox<String> cbSupplier = new JComboBox<>();
	private final JButton btnUpdate = new JButton("Update");

	private final MedicinesEntity medicine;
	private final MedicinesDao medicineDao = new MedicinesDao();
	private final List<Map.Entry<Integer, String>> categories;
	private final List<Map.Entry<Integer, String>> suppliers;

	public UpdateMedicine(MedicinesEntity medicine, List<Map.Entry<Integer, String>> categories,
			List<Map.Entry<Integer, String>> suppliers) {
		this.medicine = medicine;
		this.categories = categories;
		this.suppliers = suppliers;

		setTitle("Update Medicine");
		setLayout(new GridLayout(8, 2, 10, 10));
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Medicine Name
		add(new JLabel("Medicine Name:"));
		txtName.setText(medicine.getMedicine_name());
		add(txtName);

		// Price
		add(new JLabel("Price:"));
		txtPrice.setText(String.valueOf(medicine.getPrice()));
		add(txtPrice);

		// Stock
		add(new JLabel("Stock:"));
		txtStock.setText(String.valueOf(medicine.getStock()));
		add(txtStock);

		// Category
		add(new JLabel("Category:"));
		for (Map.Entry<Integer, String> category : categories) {
			cbCategory.addItem(category.getValue());
		}
		String currentCategoryName = getCategoryNameById(medicine.getCategory_id());
		cbCategory.setSelectedItem(currentCategoryName);
		add(cbCategory);

		// Manufacturing Date
		add(new JLabel("Manufacturing Date (YYYY-MM-DD):"));
		txtManufacturingDate.setText(medicine.getManufacturing_date().toString());
		add(txtManufacturingDate);

		// Expiry Date
		add(new JLabel("Expiry Date (YYYY-MM-DD):"));
		txtExpiryDate.setText(medicine.getExpiry_date().toString());
		add(txtExpiryDate);

		// Supplier
		add(new JLabel("Supplier:"));
		for (Map.Entry<Integer, String> supplier : suppliers) {
			cbSupplier.addItem(supplier.getValue());
		}
		String currentSupplierName = getSupplierNameById(medicine.getSupplier_id());
		cbSupplier.setSelectedItem(currentSupplierName);
		add(cbSupplier);

		// Update Button
		add(new JLabel());
		add(btnUpdate);

		// Add action listener for update button
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleUpdate();
			}
		});

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void handleUpdate() {
		try {
			// Lấy thông tin từ form
			String medicineName = txtName.getText();
			String selectedCategoryName = (String) cbCategory.getSelectedItem();
			String selectedSupplierName = (String) cbSupplier.getSelectedItem();

			// Tìm ID của category và supplier đã chọn
			int categoryId = categories.stream().filter(entry -> entry.getValue().equals(selectedCategoryName))
					.map(Map.Entry::getKey).findFirst().orElse(-1);

			int supplierId = suppliers.stream().filter(entry -> entry.getValue().equals(selectedSupplierName))
					.map(Map.Entry::getKey).findFirst().orElse(-1);

			// Lấy các thông tin khác từ form
			int price = Integer.parseInt(txtPrice.getText());
			int stock = Integer.parseInt(txtStock.getText());
			LocalDate manufacturingDate = LocalDate.parse(txtManufacturingDate.getText());
			LocalDate expiryDate = LocalDate.parse(txtExpiryDate.getText());

			// Cập nhật thông tin thuốc
			medicine.setMedicine_name(medicineName);
			medicine.setCategory_id(categoryId);
			medicine.setSupplier_id(supplierId);
			medicine.setPrice(price);
			medicine.setStock(stock);
			medicine.setManufacturing_date(manufacturingDate);
			medicine.setExpiry_date(expiryDate);

			// Gửi yêu cầu cập nhật vào database
			medicineDao.updateMedicine(medicine);

			// Hiển thị thông báo thành công
			JOptionPane.showMessageDialog(this, "Medicine updated successfully!");
			dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error updating medicine: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private String getCategoryNameById(int categoryId) {
		return categories.stream().filter(entry -> entry.getKey() == categoryId).map(Map.Entry::getValue).findFirst()
				.orElse("Unknown");
	}

	private String getSupplierNameById(int supplierId) {
		return suppliers.stream().filter(entry -> entry.getKey() == supplierId).map(Map.Entry::getValue).findFirst()
				.orElse("Unknown");
	}
}
