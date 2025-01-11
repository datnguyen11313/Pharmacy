package gui.medicine;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.CategoriesDao;
import dao.MedicinesDao;
import dao.SuppliersDao;
import entity.CategoriesEntity;
import entity.MedicinesEntity;
import entity.SupplierEntity;

public class AddMedicine extends JFrame {
	private JTextField txtMedicineName, txtPrice, txtStock, txtManufacturingDate, txtExpiryDate, txtUnit,
			txtConcentration, txtUsage, txtContraindications, txtSideEffects, txtStorage, txtIngredients;
	private JComboBox<CategoriesEntity> cbCategory; // Sử dụng CategoriesEntity
	private JComboBox<SupplierEntity> cbSupplier; // Sử dụng SupplierEntity
	private JButton btnAdd, btnCancel, btnSelectImage;
	private String selectedImagePath = ""; // Để lưu đường dẫn ảnh chọn

	public AddMedicine() {
		setTitle("Thêm thuốc mới");
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(0, 2, 10, 10)); // Tự động số hàng, 2 cột, khoảng cách 10px

		// Dòng 1: Tên thuốc
		add(new JLabel("Tên thuốc:"));
		txtMedicineName = new JTextField();
		add(txtMedicineName);

		// Dòng 2: Danh mục thuốc
		add(new JLabel("Danh mục:"));
		cbCategory = new JComboBox<>();
		loadCategories(); // Load danh mục từ DAO
		cbCategory.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof CategoriesEntity) {
					setText(((CategoriesEntity) value).getCaterogy_name());
				}
				return this;
			}
		});
		add(cbCategory);

		// Dòng 3: Nhà cung cấp
		add(new JLabel("Nhà cung cấp:"));
		cbSupplier = new JComboBox<>();
		loadSuppliers(); // Load nhà cung cấp từ DAO
		cbSupplier.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof SupplierEntity) {
					setText(((SupplierEntity) value).getSupplier_name());
				}
				return this;
			}
		});
		add(cbSupplier);

		// Dòng 4: Giá
		add(new JLabel("Giá (VNĐ):"));
		txtPrice = new JTextField();
		add(txtPrice);

		// Dòng 5: Số lượng
		add(new JLabel("Số lượng:"));
		txtStock = new JTextField();
		add(txtStock);

		// Dòng 6: Ngày sản xuất
		add(new JLabel("Ngày sản xuất (yyyy-MM-dd):"));
		txtManufacturingDate = new JTextField();
		add(txtManufacturingDate);

		// Dòng 7: Hạn sử dụng
		add(new JLabel("Hạn sử dụng (yyyy-MM-dd):"));
		txtExpiryDate = new JTextField();
		add(txtExpiryDate);

		// Dòng 8: Đơn vị
		add(new JLabel("Đơn vị:"));
		txtUnit = new JTextField();
		add(txtUnit);

		// Dòng 9: Nồng độ
		add(new JLabel("Nồng độ:"));
		txtConcentration = new JTextField();
		add(txtConcentration);

		// Dòng 10: Cách sử dụng
		add(new JLabel("Cách sử dụng:"));
		txtUsage = new JTextField();
		add(txtUsage);

		// Dòng 11: Chống chỉ định
		add(new JLabel("Chống chỉ định:"));
		txtContraindications = new JTextField();
		add(txtContraindications);

		// Dòng 12: Tác dụng phụ
		add(new JLabel("Tác dụng phụ:"));
		txtSideEffects = new JTextField();
		add(txtSideEffects);

		// Dòng 13: Cách bảo quản
		add(new JLabel("Cách bảo quản:"));
		txtStorage = new JTextField();
		add(txtStorage);

		// Dòng 14: Thành phần
		add(new JLabel("Thành phần:"));
		txtIngredients = new JTextField();
		add(txtIngredients);

		// Dòng 15: Chọn hình ảnh
		add(new JLabel("Chọn hình ảnh:"));
		btnSelectImage = new JButton("Chọn ảnh");
		add(btnSelectImage);

		// Dòng 16: Nút Thêm và Hủy
		btnAdd = new JButton("Thêm");
		btnCancel = new JButton("Hủy");
		add(btnAdd);
		add(btnCancel);

		// Gắn sự kiện cho nút chọn ảnh
		btnSelectImage.addActionListener(e -> {
			// Mở JFileChooser để chọn hình ảnh
			var fileChooser = new JFileChooser();

			// Đặt thư mục mặc định là folder "images" trong project
			var defaultDirectory = System.getProperty("user.dir") + File.separator + "images";
			fileChooser.setCurrentDirectory(new File(defaultDirectory));

			// Lọc file chỉ cho phép chọn ảnh
			fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

			var returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				var selectedFile = fileChooser.getSelectedFile();
				selectedImagePath = selectedFile.getAbsolutePath();
				JOptionPane.showMessageDialog(null, "Đã chọn hình ảnh: " + selectedImagePath);
			}
		});

		// Gắn sự kiện cho nút Thêm
		btnAdd.addActionListener(this::btnAddMedicineActionPerformed);

		// Gắn sự kiện cho nút Hủy
		btnCancel.addActionListener(e -> dispose());
	}

	private void loadCategories() {
		var categoriesDao = new CategoriesDao();
		var categories = categoriesDao.getAllCategoriesThinh();
		for (CategoriesEntity category : categories) {
			cbCategory.addItem(category);
		}
	}

	private void loadSuppliers() {
		var supplierDao = new SuppliersDao();
		var suppliers = supplierDao.getAllSuppliers();
		for (SupplierEntity supplier : suppliers) {
			cbSupplier.addItem(supplier);
		}
	}

	protected void btnAddMedicineActionPerformed(ActionEvent e) {
		// Lấy dữ liệu từ giao diện
		var medicineName = txtMedicineName.getText().trim();
		var selectedCategory = (CategoriesEntity) cbCategory.getSelectedItem();
		var selectedSupplier = (SupplierEntity) cbSupplier.getSelectedItem();
		var price = txtPrice.getText().trim();
		var stock = txtStock.getText().trim();
		var manufacturingDate = txtManufacturingDate.getText().trim();
		var expiryDate = txtExpiryDate.getText().trim();
		var unit = txtUnit.getText().trim();
		var concentration = txtConcentration.getText().trim();
		var usage = txtUsage.getText().trim();
		var contraindications = txtContraindications.getText().trim();
		var sideEffects = txtSideEffects.getText().trim();
		var storage = txtStorage.getText().trim();
		var ingredients = txtIngredients.getText().trim();

		// Kiểm tra nếu các trường quan trọng bị bỏ trống
		if (medicineName.isEmpty() || price.isEmpty() || stock.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin thuốc!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Kiểm tra nếu danh mục và nhà cung cấp chưa được chọn
		if (selectedCategory == null || selectedSupplier == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn danh mục và nhà cung cấp!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Kiểm tra nếu dữ liệu ngày tháng hợp lệ
		try {
			var manufacturingDateParsed = LocalDate.parse(manufacturingDate);
			var expiryDateParsed = LocalDate.parse(expiryDate);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Ngày sản xuất và hạn sử dụng phải có định dạng yyyy-MM-dd!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Tạo đối tượng MedicinesEntity
		var newMedicine = new MedicinesEntity();
		newMedicine.setMedicine_name(medicineName);
		newMedicine.setCategory(selectedCategory);
		newMedicine.setSupplier(selectedSupplier);
		newMedicine.setPrice(new BigDecimal(price));
		newMedicine.setStock(Integer.parseInt(stock));
		newMedicine.setManufacturing_date(LocalDate.parse(manufacturingDate));
		newMedicine.setExpiry_date(LocalDate.parse(expiryDate));
		newMedicine.setUnit(unit);
		newMedicine.setConcentration(concentration);
		newMedicine.setUsage(usage);
		newMedicine.setContraindications(contraindications);
		newMedicine.setSide_effects(sideEffects);
		newMedicine.setStorage(storage);
		newMedicine.setIngredients(ingredients);

		// Gắn thêm đường dẫn ảnh
		newMedicine.setPicture(selectedImagePath); // Lưu đường dẫn hình ảnh vào đối tượng

		// Gọi phương thức addMedicine để thêm thuốc vào cơ sở dữ liệu
		var medicinesDao = new MedicinesDao();
		medicinesDao.addMedicine(newMedicine);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			var frame = new AddMedicine();
			frame.setVisible(true);
		});
	}
}
