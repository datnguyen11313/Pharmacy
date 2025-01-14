package gui.EmployeeGUI;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import entity.EmployeeEntity;

public class UpdateEmployeeFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField fullNameField, phoneNumberField, emailField, addressField, identityCardField, salaryField,
			startDateField, pictureField, roleField;
	private int employeeId;
	private JTable table;
	private int selectedRow;
	private String selectedPicturePath; // Đường dẫn ảnh được chọn

	public UpdateEmployeeFrame(int employeeId, JTable table, int selectedRow) {
		this.employeeId = employeeId;
		this.table = table;
		this.selectedRow = selectedRow;

		setTitle("Update Employee");
		setSize(400, 500); // Tăng kích thước JFrame để chứa thêm trường
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Layout
		var panel = new JPanel(new GridLayout(0, 2, 10, 10));
		add(panel);

		// Lấy thông tin từ bảng
		var oldFullName = table.getValueAt(selectedRow, 1).toString();
		var oldPhoneNumber = table.getValueAt(selectedRow, 2).toString();
		var oldEmail = table.getValueAt(selectedRow, 3).toString();
		var oldAddress = table.getValueAt(selectedRow, 4).toString();
		var oldIdentityCard = table.getValueAt(selectedRow, 5).toString();
		var oldRole = "Employee"; // Hiển thị tên role có id = 2
		var oldSalary = Double.parseDouble(table.getValueAt(selectedRow, 7).toString());
		var oldStartDate = table.getValueAt(selectedRow, 10).toString();
		var oldPicture = table.getValueAt(selectedRow, 11).toString(); // Lấy đường dẫn ảnh cũ

		// Các trường nhập liệu
		panel.add(new JLabel("Full Name:"));
		fullNameField = new JTextField(oldFullName);
		panel.add(fullNameField);

		panel.add(new JLabel("Phone Number:"));
		phoneNumberField = new JTextField(oldPhoneNumber);
		panel.add(phoneNumberField);

		panel.add(new JLabel("Email:"));
		emailField = new JTextField(oldEmail);
		panel.add(emailField);

		panel.add(new JLabel("Address:"));
		addressField = new JTextField(oldAddress);
		panel.add(addressField);

		panel.add(new JLabel("Identity Card:"));
		identityCardField = new JTextField(oldIdentityCard);
		panel.add(identityCardField);

		panel.add(new JLabel("Role:"));
		roleField = new JTextField(oldRole);
		roleField.setEnabled(false); // Không cho phép sửa Role
		panel.add(roleField);

		panel.add(new JLabel("Salary:"));
		salaryField = new JTextField(String.valueOf(oldSalary));
		panel.add(salaryField);

		panel.add(new JLabel("Start Date (yyyy-MM-dd):"));
		startDateField = new JTextField(oldStartDate);
		panel.add(startDateField);

		panel.add(new JLabel("Picture:"));
		pictureField = new JTextField(oldPicture);
		pictureField.setEditable(false); // Không cho phép nhập trực tiếp
		panel.add(pictureField);

		// Nút chọn hình ảnh
		var choosePictureButton = new JButton("Choose Picture");
		choosePictureButton.addActionListener(e -> choosePicture());
		panel.add(new JLabel()); // Dòng trống
		panel.add(choosePictureButton);

		// Nút Save
		var saveButton = new JButton("Save");
		panel.add(new JLabel()); // Dòng trống
		panel.add(saveButton);

		// Xử lý sự kiện nút Save
		saveButton.addActionListener(e -> saveEmployee());

		setVisible(true);
	}

	private void choosePicture() {
		var fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		var result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			var selectedFile = fileChooser.getSelectedFile();

			// Tạo thư mục lưu ảnh trong dự án nếu chưa có
			var projectImagePath = "src/main/resources/img/"; // Thư mục lưu ảnh
			var projectImageDir = new File(projectImagePath);
			if (!projectImageDir.exists()) {
				projectImageDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
			}

			// Copy file vào thư mục của dự án
			try {
				var destinationFile = new File(projectImagePath + selectedFile.getName());
				java.nio.file.Files.copy(selectedFile.toPath(), destinationFile.toPath(),
						java.nio.file.StandardCopyOption.REPLACE_EXISTING);

				// Lưu đường dẫn tương đối vào biến selectedPicturePath
				selectedPicturePath = "images/" + selectedFile.getName();
				pictureField.setText(selectedPicturePath); // Hiển thị đường dẫn tương đối vào trường Picture

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Failed to copy the picture. Please try again.", "Error",
						JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}

	private void saveEmployee() {
		try {
			// Lấy dữ liệu từ các trường nhập liệu
			var newFullName = fullNameField.getText();
			var newPhoneNumber = phoneNumberField.getText();
			var newEmail = emailField.getText();
			var newAddress = addressField.getText();
			var newIdentityCard = identityCardField.getText();
			var newSalary = Double.parseDouble(salaryField.getText());
			var newStartDate = java.sql.Date.valueOf(startDateField.getText());
			var newPicture = pictureField.getText(); // Lấy đường dẫn ảnh mới

			// Tạo đối tượng EmployeeEntity
			var updatedEmployee = new EmployeeEntity();
			updatedEmployee.setId(employeeId);
			updatedEmployee.setFullName(newFullName);
			updatedEmployee.setPhoneNumber(newPhoneNumber);
			updatedEmployee.setEmail(newEmail);
			updatedEmployee.setAddress(newAddress);
			updatedEmployee.setIdentityCard(newIdentityCard);
			updatedEmployee.setRoleID(2); // Luôn lưu Role ID = 2
			updatedEmployee.setSalary(newSalary);
			updatedEmployee.setStartDate(newStartDate);
			updatedEmployee.setPicture(newPicture);
			updatedEmployee.setUpdatedAt(new java.util.Date());

			// Gọi DAO để cập nhật
			var employeeDAO = new EmployeeDAO();
			var isUpdated = employeeDAO.updateEmployee(updatedEmployee);

			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "Employee updated successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);

				// Cập nhật lại bảng
				table.setValueAt(newFullName, selectedRow, 1);
				table.setValueAt(newPhoneNumber, selectedRow, 2);
				table.setValueAt(newEmail, selectedRow, 3);
				table.setValueAt(newAddress, selectedRow, 4);
				table.setValueAt(newIdentityCard, selectedRow, 5);
				table.setValueAt("2", selectedRow, 6); // Luôn hiển thị tên "Employee"
				table.setValueAt(newSalary, selectedRow, 7);
				table.setValueAt(newStartDate, selectedRow, 8);
				table.setValueAt(newPicture, selectedRow, 11); // Cập nhật đường dẫn ảnh

				// Đóng JFrame
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Invalid input data. Please try again.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
