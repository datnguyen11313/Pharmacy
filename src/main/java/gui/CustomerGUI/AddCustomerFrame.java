package gui.CustomerGUI;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CustomerDAO;
import entity.CustomerEntity;

public class AddCustomerFrame extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fullNameField, phoneNumberField, emailField, addressField, pictureField, dateOfBirthField,
			customerTypeField, pointsField;
	private String selectedPicturePath;

	public AddCustomerFrame() {
		setTitle("Add New Customer");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		var panel = new JPanel(new GridLayout(0, 2, 10, 10));
		add(panel);

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

		panel.add(new JLabel("Date of Birth (yyyy-MM-dd):"));
		dateOfBirthField = new JTextField();
		panel.add(dateOfBirthField);

		panel.add(new JLabel("Customer Type:"));
		customerTypeField = new JTextField();
		panel.add(customerTypeField);

		panel.add(new JLabel("Points:"));
		pointsField = new JTextField();
		panel.add(pointsField);

		panel.add(new JLabel("Picture:"));
		pictureField = new JTextField();
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

			var newCustomer = new CustomerEntity();
			newCustomer.setFull_name(fullName);
			newCustomer.setPhone_number(phoneNumber);
			newCustomer.setEmail(email);
			newCustomer.setAddress(address);
			newCustomer.setDateOfBirth(dateOfBirth);
			newCustomer.setCustomerType(customerType);
			newCustomer.setPoints(points);
			newCustomer.setPicture(picture);
			newCustomer.setCreatedAt(new java.util.Date());
			newCustomer.setUpdatedAt(new java.util.Date());
			newCustomer.setDelete(false); // Default is not deleted

			var customerDAO = new CustomerDAO();
			var isInserted = customerDAO.addCustomer(newCustomer);

			if (isInserted) {
				JOptionPane.showMessageDialog(this, "Customer added successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Invalid input data.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
