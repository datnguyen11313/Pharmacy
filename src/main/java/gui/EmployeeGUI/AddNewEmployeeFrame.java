package gui.EmployeeGUI;

import java.awt.GridLayout;
import java.io.File;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import entity.EmployeeEntity;

public class AddNewEmployeeFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField fullNameField, phoneNumberField, emailField, addressField, identityCardField, pictureField,
			salaryField, startDateField;
	private String selectedPicturePath; // Đường dẫn ảnh được chọn

	public AddNewEmployeeFrame() {
		setTitle("Add Employee");
		setSize(400, 600); // Kích thước JFrame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Layout
		var panel = new JPanel(new GridLayout(0, 2, 10, 10));
		add(panel);

		// Các trường nhập liệu
		panel.add(new JLabel("Full Name:"));
		fullNameField = new JTextField();
		panel.add(fullNameField);

		panel.add(new JLabel("Phone Number:"));
		phoneNumberField = new JTextField();
		panel.add(phoneNumberField);

		panel.add(new JLabel("Email:"));
		emailField = new JTextField();
		panel.add(emailField);

		panel.add(new JLabel("Address:"));
		addressField = new JTextField();
		panel.add(addressField);

		panel.add(new JLabel("Identity Card:"));
		identityCardField = new JTextField();
		panel.add(identityCardField);

		panel.add(new JLabel("Picture:"));
		pictureField = new JTextField();
		pictureField.setEditable(false); // Không cho phép nhập tay
		panel.add(pictureField);

		// Nút chọn hình ảnh
		var choosePictureButton = new JButton("Choose Picture");
		choosePictureButton.addActionListener(e -> choosePicture());
		panel.add(new JLabel()); // Dòng trống
		panel.add(choosePictureButton);

		panel.add(new JLabel("Salary:"));
		salaryField = new JTextField();
		panel.add(salaryField);

		panel.add(new JLabel("Start Date (yyyy-MM-dd):"));
		startDateField = new JTextField();
		panel.add(startDateField);

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

				// Cập nhật giao diện
				this.revalidate();
				this.repaint();

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
			var fullName = fullNameField.getText();
			var phoneNumber = phoneNumberField.getText();
			var email = emailField.getText();
			var address = addressField.getText();
			var identityCard = identityCardField.getText();
			var picture = pictureField.getText();
			var salaryStr = salaryField.getText();
			var startDateStr = startDateField.getText();

			// Kiểm tra trường bắt buộc
			if (fullName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || address.isEmpty()
					|| identityCard.isEmpty() || salaryStr.isEmpty() || startDateStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error",
						JOptionPane.ERROR_MESSAGE);
				return; // Dừng lại nếu có trường trống
			}

			// Kiểm tra định dạng số điện thoại (chỉ là ví dụ, bạn có thể sử dụng biểu thức
			// chính quy)
			if (!phoneNumber.matches("\\d{10}")) { // Giả sử số điện thoại là 10 chữ số
				JOptionPane.showMessageDialog(this, "Invalid phone number format. It must be 10 digits.",
						"Validation Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Kiểm tra định dạng email
			if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
				JOptionPane.showMessageDialog(this, "Invalid email format.", "Validation Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Kiểm tra định dạng ngày (yyyy-MM-dd)
			try {
				Date.valueOf(startDateStr); // Kiểm tra xem ngày có hợp lệ không
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.", "Validation Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Kiểm tra số lương (Salary)
			double salary;
			try {
				salary = Double.parseDouble(salaryStr);
				if (salary <= 0) {
					JOptionPane.showMessageDialog(this, "Salary must be greater than 0.", "Validation Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Invalid salary. Please enter a valid number.", "Validation Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Kiểm tra identity card (ví dụ: chỉ số và dài ít nhất 9 ký tự)
			if (!identityCard.matches("\\d{9,12}")) { // Giả sử CMND/CCCD có từ 9 đến 12 chữ số
				JOptionPane.showMessageDialog(this, "Invalid identity card number. It must be between 9 and 12 digits.",
						"Validation Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Tạo đối tượng EmployeeEntity
			var newEmployee = new EmployeeEntity();
			newEmployee.setFullName(fullName);
			newEmployee.setPhoneNumber(phoneNumber);
			newEmployee.setEmail(email);
			newEmployee.setAddress(address);
			newEmployee.setIdentityCard(identityCard);
			newEmployee.setPicture(picture);
			newEmployee.setSalary(salary);
			newEmployee.setStartDate(Date.valueOf(startDateStr));
			newEmployee.setRoleID(2); // Role mặc định là Employee (2)
			newEmployee.setCreatedAt(new java.util.Date());
			newEmployee.setUpdatedAt(new java.util.Date());
			newEmployee.setDelete(false); // Mặc định isDelete = false

			// Gọi DAO để thêm nhân viên
			var employeeDAO = new EmployeeDAO();
			var isInserted = employeeDAO.addEmployee(newEmployee);

			if (isInserted) {
				JOptionPane.showMessageDialog(this, "Employee added successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);

				dispose(); // Đóng JFrame
			} else {
				JOptionPane.showMessageDialog(this, "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Invalid input data. Please try again.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
}