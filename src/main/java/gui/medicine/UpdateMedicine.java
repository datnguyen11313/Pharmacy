package gui.medicine;

import java.io.File;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.CategoriesDao;
import dao.MedicinesDao;
import dao.SuppliersDao;
import entity.CategoriesEntity;
import entity.MedicinesEntity;
import entity.SupplierEntity;

public class UpdateMedicine extends JFrame {
	private MedicinesEntity medicine;
	private JTextField txtMedicineName, txtPrice, txtStock, txtPicture, txtUnit, txtConcentration, txtUsage,
			txtContraindications, txtSideEffects, txtStorage, txtIngredients;
	private JComboBox<String> cbCategory;
	private JComboBox<String> cbSupplier;
	private JSpinner spManufacturingDate, spExpiryDate;

	public UpdateMedicine(MedicinesEntity medicine) {
		this.medicine = medicine;
		initComponents();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cập nhật thuốc");
		setSize(700, 700); // Tăng kích thước form để người dùng có thể điền đầy đủ thông tin
		setLocationRelativeTo(null);
		loadFormData();
	}

	private void initComponents() {
		var panel = new JPanel();
		panel.setLayout(null); // Layout cho form

		var lblMedicineName = new JLabel("Tên thuốc:");
		lblMedicineName.setBounds(30, 30, 120, 25);
		panel.add(lblMedicineName);

		txtMedicineName = new JTextField();
		txtMedicineName.setBounds(150, 30, 300, 25);
		panel.add(txtMedicineName);

		var lblCategory = new JLabel("Danh mục:");
		lblCategory.setBounds(30, 70, 120, 25);
		panel.add(lblCategory);

		cbCategory = new JComboBox<>();
		cbCategory.setBounds(150, 70, 300, 25);
		panel.add(cbCategory);

		var lblSupplier = new JLabel("Nhà cung cấp:");
		lblSupplier.setBounds(30, 110, 120, 25);
		panel.add(lblSupplier);

		cbSupplier = new JComboBox<>();
		cbSupplier.setBounds(150, 110, 300, 25);
		panel.add(cbSupplier);

		var lblPrice = new JLabel("Giá:");
		lblPrice.setBounds(30, 150, 120, 25);
		panel.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setBounds(150, 150, 300, 25);
		panel.add(txtPrice);

		var lblStock = new JLabel("Số lượng:");
		lblStock.setBounds(30, 190, 120, 25);
		panel.add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(150, 190, 300, 25);
		panel.add(txtStock);

		var lblManufacturingDate = new JLabel("Ngày sản xuất:");
		lblManufacturingDate.setBounds(30, 230, 120, 25);
		panel.add(lblManufacturingDate);

		spManufacturingDate = new JSpinner(new SpinnerDateModel());
		spManufacturingDate.setBounds(150, 230, 300, 25);
		var manufacturingDateEditor = new JSpinner.DateEditor(spManufacturingDate, "yyyy-MM-dd");
		spManufacturingDate.setEditor(manufacturingDateEditor);
		panel.add(spManufacturingDate);

		var lblExpiryDate = new JLabel("Ngày hết hạn:");
		lblExpiryDate.setBounds(30, 270, 120, 25);
		panel.add(lblExpiryDate);

		spExpiryDate = new JSpinner(new SpinnerDateModel());
		spExpiryDate.setBounds(150, 270, 300, 25);
		var expiryDateEditor = new JSpinner.DateEditor(spExpiryDate, "yyyy-MM-dd");
		spExpiryDate.setEditor(expiryDateEditor);
		panel.add(spExpiryDate);

		// Chỉnh sửa phần Hình ảnh
		var lblPicture = new JLabel("Hình ảnh:");
		lblPicture.setBounds(30, 310, 120, 25);
		panel.add(lblPicture);

		txtPicture = new JTextField();
		txtPicture.setBounds(150, 310, 300, 25);
		panel.add(txtPicture);

		var btnChoosePicture = new JButton("Chọn ảnh");
		btnChoosePicture.setBounds(460, 310, 120, 25);
		panel.add(btnChoosePicture);

		btnChoosePicture.addActionListener(e -> chooseImage());

		var lblUnit = new JLabel("Đơn vị:");
		lblUnit.setBounds(30, 350, 120, 25);
		panel.add(lblUnit);

		txtUnit = new JTextField();
		txtUnit.setBounds(150, 350, 300, 25);
		panel.add(txtUnit);

		var lblConcentration = new JLabel("Nồng độ:");
		lblConcentration.setBounds(30, 390, 120, 25);
		panel.add(lblConcentration);

		txtConcentration = new JTextField();
		txtConcentration.setBounds(150, 390, 300, 25);
		panel.add(txtConcentration);

		var lblUsage = new JLabel("Cách sử dụng:");
		lblUsage.setBounds(30, 430, 120, 25);
		panel.add(lblUsage);

		txtUsage = new JTextField();
		txtUsage.setBounds(150, 430, 300, 25);
		panel.add(txtUsage);

		var lblContraindications = new JLabel("Chống chỉ định:");
		lblContraindications.setBounds(30, 470, 120, 25);
		panel.add(lblContraindications);

		txtContraindications = new JTextField();
		txtContraindications.setBounds(150, 470, 300, 25);
		panel.add(txtContraindications);

		var lblSideEffects = new JLabel("Tác dụng phụ:");
		lblSideEffects.setBounds(30, 510, 120, 25);
		panel.add(lblSideEffects);

		txtSideEffects = new JTextField();
		txtSideEffects.setBounds(150, 510, 300, 25);
		panel.add(txtSideEffects);

		var lblStorage = new JLabel("Bảo quản:");
		lblStorage.setBounds(30, 550, 120, 25);
		panel.add(lblStorage);

		txtStorage = new JTextField();
		txtStorage.setBounds(150, 550, 300, 25);
		panel.add(txtStorage);

		var lblIngredients = new JLabel("Thành phần:");
		lblIngredients.setBounds(30, 590, 120, 25);
		panel.add(lblIngredients);

		txtIngredients = new JTextField();
		txtIngredients.setBounds(150, 590, 300, 25);
		panel.add(txtIngredients);

		var btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(150, 630, 120, 30);
		panel.add(btnUpdate);

		var btnCancel = new JButton("Hủy");
		btnCancel.setBounds(330, 630, 120, 30);
		panel.add(btnCancel);

		btnUpdate.addActionListener(e -> updateMedicine());

		btnCancel.addActionListener(e -> dispose());

		// Thêm JScrollPane để cuộn form khi dài
		var scrollPane = new JScrollPane(panel);
		setContentPane(scrollPane);
	}

	private void loadFormData() {
		txtMedicineName.setText(medicine.getMedicine_name());
		txtPrice.setText(medicine.getPrice().toString());
		txtStock.setText(String.valueOf(medicine.getStock()));
		txtPicture.setText(medicine.getPicture());
		txtUnit.setText(medicine.getUnit());
		txtConcentration.setText(medicine.getConcentration());
		txtUsage.setText(medicine.getUsage());
		txtContraindications.setText(medicine.getContraindications());
		txtSideEffects.setText(medicine.getSide_effects());
		txtStorage.setText(medicine.getStorage());
		txtIngredients.setText(medicine.getIngredients());

		var categories = new CategoriesDao().getAllCategoriesThinh();
		for (CategoriesEntity category : categories) {
			cbCategory.addItem(category.getCaterogy_name());
			if (category.getId() == medicine.getCategory().getId()) {
				cbCategory.setSelectedItem(category.getCaterogy_name());
			}
		}

		List<SupplierEntity> suppliers = new SuppliersDao().getAllSuppliers();
		for (SupplierEntity supplier : suppliers) {
			cbSupplier.addItem(supplier.getSupplier_name());
			if (supplier.getId() == medicine.getSupplier().getId()) {
				cbSupplier.setSelectedItem(supplier.getSupplier_name());
			}
		}

		spManufacturingDate.setValue(java.sql.Date.valueOf(medicine.getManufacturing_date()));
		spExpiryDate.setValue(java.sql.Date.valueOf(medicine.getExpiry_date()));
	}

	private void chooseImage() {
		var fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn ảnh");
		fileChooser.setCurrentDirectory(new File("images")); // Mở thư mục "images" trong project
		fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "gif"));

		var result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			var selectedFile = fileChooser.getSelectedFile();
			txtPicture.setText(selectedFile.getAbsolutePath()); // Hiển thị đường dẫn ảnh vào text field
		}
	}

	private void updateMedicine() {
		try {
			medicine.setMedicine_name(txtMedicineName.getText());
			medicine.setPrice(new BigDecimal(txtPrice.getText()));
			medicine.setStock(Integer.parseInt(txtStock.getText()));
			medicine.setPicture(txtPicture.getText());
			medicine.setUnit(txtUnit.getText());
			medicine.setConcentration(txtConcentration.getText());
			medicine.setUsage(txtUsage.getText());
			medicine.setContraindications(txtContraindications.getText());
			medicine.setSide_effects(txtSideEffects.getText());
			medicine.setStorage(txtStorage.getText());
			medicine.setIngredients(txtIngredients.getText());

			// Lấy giá trị từ spinner (kiểu Date)
			var manufacturingDate = (java.util.Date) spManufacturingDate.getValue();
			var expiryDate = (java.util.Date) spExpiryDate.getValue();

			// Chuyển đổi Date thành LocalDate
			medicine.setManufacturing_date(manufacturingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			medicine.setExpiry_date(expiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

			// Gọi DAO để cập nhật thuốc
			new MedicinesDao().updateMedicine(medicine);
			dispose(); // Đóng cửa sổ sau khi cập nhật thành công
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi cập nhật thuốc: " + e.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
