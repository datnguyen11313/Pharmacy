package gui.CustomerGUI;

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

import dao.CustomerDAO;
import entity.CustomerEntity;

public class UpdateCustomerFrame extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fullNameField, phoneNumberField, emailField, addressField, pictureField, dateOfBirthField,
			customerTypeField, pointsField;
	private int customerId;
	private JTable table;
	private int selectedRow;
	private String selectedPicturePath;

	public UpdateCustomerFrame(int customerId, JTable table, int selectedRow) {
		this.customerId = customerId;
		this.table = table;
		this.selectedRow = selectedRow;

		setTitle("Update Customer");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		var panel = new JPanel(new GridLayout(0, 2, 10, 10));
		add(panel);

		var oldFullName = table.getValueAt(selectedRow, 1).toString();
		var oldPhoneNumber = table.getValueAt(selectedRow, 2).toString();
		var oldEmail = table.getValueAt(selectedRow, 3).toString();
		var oldAddress = table.getValueAt(selectedRow, 4).toString();
		var oldDateOfBirth = table.getValueAt(selectedRow, 5).toString();
		var oldCustomerType = table.getValueAt(selectedRow, 6).toString();
		var oldPoints = Integer.parseInt(table.getValueAt(selectedRow, 7).toString());
		var oldPicture = table.getValueAt(selectedRow, 8).toString();

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

		panel.add(new JLabel("Date of Birth (yyyy-MM-dd):"));
		dateOfBirthField = new JTextField(oldDateOfBirth);
		panel.add(dateOfBirthField);

		panel.add(new JLabel("Customer Type:"));
		customerTypeField = new JTextField(oldCustomerType);
		panel.add(customerTypeField);

		panel.add(new JLabel("Points:"));
		pointsField = new JTextField(String.valueOf(oldPoints));
		panel.add(pointsField);

		panel.add(new JLabel("Picture:"));
		pictureField = new JTextField(oldPicture);
		pictureField.setEditable(false);
		panel.add(pictureField);

		var choosePictureButton = new JButton("Choose Picture");
		choosePictureButton.addActionListener(e -> choosePicture());
		panel.add(new JLabel());
		panel.add(choosePictureButton);

		var saveButton = new JButton("Save");
		panel.add(new JLabel());
		panel.add(saveButton);

		saveButton.addActionListener(e -> saveCustomer());

		setVisible(true);
	}

	private void choosePicture() {
		var fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		var result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			var selectedFile = fileChooser.getSelectedFile();
			var projectImagePath = "src/main/resources/img/";
			var projectImageDir = new File(projectImagePath);
			if (!projectImageDir.exists()) {
				projectImageDir.mkdirs();
			}

			try {
				var destinationFile = new File(projectImagePath + selectedFile.getName());
				java.nio.file.Files.copy(selectedFile.toPath(), destinationFile.toPath(),
						java.nio.file.StandardCopyOption.REPLACE_EXISTING);
				selectedPicturePath = "images/" + selectedFile.getName();
				pictureField.setText(selectedPicturePath);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Failed to copy the picture.", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}

	private void saveCustomer() {
		try {
			var fullName = fullNameField.getText();
			var phoneNumber = phoneNumberField.getText();
			var email = emailField.getText();
			var address = addressField.getText();
			var dateOfBirth = java.sql.Date.valueOf(dateOfBirthField.getText());
			var customerType = customerTypeField.getText();
			var points = Integer.parseInt(pointsField.getText());
			var picture = pictureField.getText();

			var updatedCustomer = new CustomerEntity();
			updatedCustomer.setId(customerId);
			updatedCustomer.setFull_name(fullName);
			updatedCustomer.setPhone_number(phoneNumber);
			updatedCustomer.setEmail(email);
			updatedCustomer.setAddress(address);
			updatedCustomer.setDateOfBirth(dateOfBirth);
			updatedCustomer.setCustomerType(customerType);
			updatedCustomer.setPoints(points);
			updatedCustomer.setPicture(picture);
			updatedCustomer.setUpdatedAt(new java.util.Date());

			var customerDAO = new CustomerDAO();
			var isUpdated = customerDAO.updateCustomer(updatedCustomer);

			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "Customer updated successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);

				table.setValueAt(fullName, selectedRow, 1);
				table.setValueAt(phoneNumber, selectedRow, 2);
				table.setValueAt(email, selectedRow, 3);
				table.setValueAt(address, selectedRow, 4);
				table.setValueAt(dateOfBirth, selectedRow, 5);
				table.setValueAt(customerType, selectedRow, 6);
				table.setValueAt(points, selectedRow, 7);
				table.setValueAt(picture, selectedRow, 8);

				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Failed to update customer.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Invalid input data.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
