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

import dao.CategoriesDAO; // Import CategoriesDAO của bạn
import dao.MedicinesDao;
import dao.SuppliersDAO;
import entity.MedicinesEntity;

public class AddMedicine extends JFrame {
	private final MedicinesDao medicineDao;
	private final CategoriesDAO categoriesDao;
	private final SuppliersDAO supplierDao;

	public AddMedicine() {
		this.medicineDao = new MedicinesDao(); // Khởi tạo DAO
		this.categoriesDao = new CategoriesDAO(); // Khởi tạo CategoriesDAO
		this.supplierDao = new SuppliersDAO();

		List<Map.Entry<Integer, String>> categories = categoriesDao.getAllCategories();
		List<Map.Entry<Integer, String>> suppliers = supplierDao.getAllSuppliers();

		if (categories.isEmpty() || suppliers.isEmpty()) {
			System.out.println("No categories found.");
		} else {
			for (Map.Entry<Integer, String> category : categories) {
				System.out.println("Category ID: " + category.getKey() + ", Category Name: " + category.getValue());
			}
		}

		setTitle("Add Medicine");
		getContentPane().setLayout(new GridLayout(9, 2, 10, 10));
		setSize(597, 430);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Các thành phần giao diện
		JLabel lblName = new JLabel("Medicine Name:");
		JTextField txtName = new JTextField();

		JLabel lblCategory = new JLabel("Category:");
		JComboBox<String> categoryComboBox = new JComboBox<>();
		for (Map.Entry<Integer, String> category : categories) {
			categoryComboBox.addItem(category.getValue());
		}

		System.out.println("Hello Supplier");

		JLabel lblSupplier = new JLabel("Supplier:");
		JComboBox<String> supplierComboBox = new JComboBox<>();
		for (Map.Entry<Integer, String> supplier : suppliers) {
			supplierComboBox.addItem(supplier.getValue());
		}

		JLabel lblPrice = new JLabel("Price:");
		JTextField txtPrice = new JTextField();

		JLabel lblStock = new JLabel("Stock:");
		JTextField txtStock = new JTextField();

		JLabel lblManufacturingDate = new JLabel("Manufacturing Date (YYYY-MM-DD):");
		JTextField txtManufacturingDate = new JTextField();

		JLabel lblExpiryDate = new JLabel("Expiry Date (YYYY-MM-DD):");
		JTextField txtExpiryDate = new JTextField();

		JButton btnSubmit = new JButton("Add Medicine");

		// Thêm thành phần vào giao diện
		getContentPane().add(lblName);
		getContentPane().add(txtName);
		getContentPane().add(lblCategory);
		getContentPane().add(categoryComboBox);
		getContentPane().add(lblSupplier);
		getContentPane().add(supplierComboBox);
		getContentPane().add(lblPrice);
		getContentPane().add(txtPrice);
		getContentPane().add(lblStock);
		getContentPane().add(txtStock);
		getContentPane().add(lblManufacturingDate);
		getContentPane().add(txtManufacturingDate);
		getContentPane().add(lblExpiryDate);
		getContentPane().add(txtExpiryDate);
		getContentPane().add(new JLabel());
		getContentPane().add(btnSubmit);

		// Xử lý sự kiện khi nhấn nút "Add Medicine"
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Lấy thông tin từ form
					String medicine_name = txtName.getText();
					String selectedCategoryName = (String) categoryComboBox.getSelectedItem();
					String selectedSupplierName = (String) supplierComboBox.getSelectedItem();

					// Tìm ID của category và supplier đã chọn
					int category_id = -1;
					int supplier_id = -1;

					for (Map.Entry<Integer, String> category : categories) {
						if (category.getValue().equals(selectedCategoryName)) {
							category_id = category.getKey();
							break;
						}
					}

					for (Map.Entry<Integer, String> supplier : suppliers) {
						if (supplier.getValue().equals(selectedSupplierName)) {
							supplier_id = supplier.getKey();
							break;
						}
					}

					// Lấy các thông tin khác từ form
					int price = Integer.parseInt(txtPrice.getText());
					int stock = Integer.parseInt(txtStock.getText());
					LocalDate manufacturing_date = LocalDate.parse(txtManufacturingDate.getText());
					LocalDate expiry_date = LocalDate.parse(txtExpiryDate.getText());

					// Tạo đối tượng Medicine
					MedicinesEntity newMedicine = new MedicinesEntity();
					newMedicine.setMedicine_name(medicine_name);
					newMedicine.setCategory_id(category_id);
					newMedicine.setPrice(price);
					newMedicine.setStock(stock);
					newMedicine.setManufacturing_date(manufacturing_date);
					newMedicine.setExpiry_date(expiry_date);
					newMedicine.setSupplier_id(supplier_id); // Gán supplier_id
					newMedicine.setDelete(false);

					// Thêm thuốc vào database
					medicineDao.addMedicine(newMedicine);

					// Hiển thị thông báo thành công
					JOptionPane.showMessageDialog(AddMedicine.this, "Medicine added successfully!");

					// Đóng form
					dispose();
				} catch (Exception ex) {
					// Hiển thị lỗi
					JOptionPane.showMessageDialog(AddMedicine.this, "Error: " + ex.getMessage());
				}
			}
		});

		setVisible(true);
	}
}
