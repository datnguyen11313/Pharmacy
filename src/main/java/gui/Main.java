package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.MedicinesDao;
import utils.UIHelper;

public class Main extends JFrame {

	private JPanel contentPanel;
	private String role;
	private JPanel navigation;
	private JPanel userInfoPanel;
	private JButton userAvatar;
	private JPanel info;
	private JPanel sideBar;
	private JPanel panelLogout;
	private JScrollPane scrollPaneSideBar;
	private JPanel contentScrollPaneSideBar;
	private JButton btnMedicineManagement;
	private JButton btnInvoiceManagement;
	private JButton btnProvider;
	private JSeparator separator;
	private JButton btnCustomer;
	private JButton btnPharmacyCounter;
	private JButton btnStatistics;
	private JSeparator separator_1;
	private JButton btnEmployee;
	private JButton btnRoleControl;
	private JButton btnLogout;
	private JPanel medicineManagementPanel;
	private JPanel medicineHeadPanel;
	private JPanel medicineDetailPanel;
	private JPanel contentContainer;
	private JPanel providerPanel;
	private JPanel invoiceManagementPanel;
	private CardLayout cardLayout;
	private JPanel headerSearchPanel;
	private JPanel headerFilterPanel;
	private JButton btnAddMedicine;
	private JPanel panel;
	private JButton btnRefresh;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblCategory;
	private JComboBox comboBox;
	private JLabel lblOrigin;
	private JComboBox comboBox_1;
	private JLabel lblUnitMeasure;
	private JComboBox comboBox_2;
	private JLabel lblDaysExpiration;
	private JPanel panel_5;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JTextField textField_1;
	private JButton btnSearchMedicine;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnHeaderAddProvider;
	private JPanel searchProviderPanel;
	private JButton btnHeaderProviderRefresh;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTextField textField_2;
	private JButton btnHeaderProviderSearch;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable table_medicines;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btnNewButton;
	private JPanel panel_12;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_16;
	private JLabel lblNewLabel_3;
	private JPanel panel_18;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel lblNewLabel_4;
	private JPanel panel_15;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	private JPanel pharmacyCounterPanel;
	private JPanel customerPanel;
	private JPanel statisticsPanel;
	private JPanel employeeManagementPanel;
	private JPanel roleControlPanel;
	private JPanel panel_17;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane_3;
	private JTable table_3;
	private JLabel lblNewLabel_7;
	private JPanel panel_24;
	private JScrollPane scrollPane_5;
	private JTable table_5;
	private JLabel lblNewLabel_8;
	private JPanel panel_25;
	private JComboBox comboBox_3;
	private JTextField txtSearch;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JTextField txtAmount;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JButton btnNewButton_6;
	private JLabel lblNewLabel_9;
	private JTextField textField_6;
	private JPanel panel_31;
	private JLabel lblNewLabel_10;
	private JTextField textField_7;
	private JPanel panel_32;
	private JLabel lblNewLabel_11;
	private JTextField textField_8;
	private JPanel panel_33;
	private JPanel panel_34;
	private JLabel lblNewLabel_12;
	private JTextField textField_9;
	private JLabel lblNewLabel_13;
	private JTextField textField_10;
	private JLabel lblNewLabel_14;
	private JTextField textField_11;
	private JLabel lblNewLabel_15;
	private JTextField textField_12;
	private JLabel lblNewLabel_16;
	private JTextField textField_13;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JPanel panel_35;
	private JPanel panel_36;
	private JButton btnNewButton_9;
	private JPanel panel_37;
	private JButton btnNewButton_10;
	private JLabel lblNewLabel_17;
	private JScrollPane scrollPane_4;
	private JTable table_1;
	private JTextField textField_14;
	private JButton btnNewButton_11;
	private JPanel panel_38;
	private JPanel panel_39;
	private JButton btnNewButton_12;
	private JPanel panel_40;
	private JButton btnNewButton_13;
	private JTextField textField_15;
	private JButton btnNewButton_14;
	private JLabel lblNewLabel_18;
	private JScrollPane scrollPane_6;
	private JTable table_4;
	private JLabel lblNewLabel_19;
	private JButton btnNewButton_15;
	private JScrollPane scrollPane_7;
	private JTable table_6;
	private JLabel lblNewLabel_20;
	private JButton btnNewButton_16;
	private JButton btnNewButton_17;
	private JButton btnNewButton_18;
	private JButton btnNewButton_19;
	private JButton btnNewButton_20;
	private JButton btnNewButton_21;
	private JButton btnNewButton_22;
	private JButton btnNewButton_23;
	private JButton btnNewButton_24;
	private JButton btnNewButton_25;
	private JButton btnNewButton_26;

	public Main(String role) {
		this.role = role; // Lưu role của người dùng
		setTitle("PharmaCity");
		// Mở ứng dụng ở chế độ full screen
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximized toàn màn hình
		setUndecorated(false); // Loại bỏ thanh tiêu đề (optional, tùy thuộc vào yêu cầu)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());

		navigation = new JPanel();
		navigation.setBackground(new Color(45, 45, 45));
		contentPanel.add(navigation, BorderLayout.WEST);
		navigation.setPreferredSize(new Dimension(200, navigation.getHeight()));

		userInfoPanel = new JPanel();
		userInfoPanel.setBackground(new Color(60, 60, 60));
		userInfoPanel.setPreferredSize(new Dimension(200, 80));
		navigation.add(userInfoPanel, BorderLayout.NORTH);

		sideBar = new JPanel();
		sideBar.setLayout(new BorderLayout());
		sideBar.setBackground(new Color(45, 45, 45));

		panelLogout = new JPanel();
		panelLogout.setBackground(new Color(60, 60, 60));
		sideBar.add(panelLogout, BorderLayout.SOUTH);

		btnLogout = new JButton("Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setPreferredSize(new Dimension(150, 40));
		btnLogout.setBackground(new Color(255, 69, 58));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFocusPainted(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelLogout.add(btnLogout);

		scrollPaneSideBar = new JScrollPane();
		scrollPaneSideBar.setBorder(null);
		scrollPaneSideBar.getViewport().setBackground(new Color(45, 45, 45));
		sideBar.add(scrollPaneSideBar, BorderLayout.CENTER);

		contentScrollPaneSideBar = new JPanel();
		contentScrollPaneSideBar.setBackground(new Color(45, 45, 45));
		scrollPaneSideBar.setViewportView(contentScrollPaneSideBar);
		contentScrollPaneSideBar.setPreferredSize(new java.awt.Dimension(150, 46));

		// Tạo từng JButton một
		btnPharmacyCounter = new JButton(
				"<html><i class='fas fa-briefcase-medical' style='font-size:36px'></i> Pharmacy Counter</html>");
		btnPharmacyCounter.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPharmacyCounter.setVerticalTextPosition(SwingConstants.CENTER);
		btnPharmacyCounter.setPreferredSize(new Dimension(170, 100));
		contentScrollPaneSideBar.add(btnPharmacyCounter);

		btnMedicineManagement = UIHelper.createStyledButton("Medicine Management");
		btnMedicineManagement.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnMedicineManagement);

		btnProvider = UIHelper.createStyledButton("Provider");
		btnProvider.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnProvider);

		btnInvoiceManagement = UIHelper.createStyledButton("Invoice Management");
		btnInvoiceManagement.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnInvoiceManagement);

		btnCustomer = UIHelper.createStyledButton("Customer");
		btnCustomer.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnCustomer);

		btnStatistics = UIHelper.createStyledButton("Statistics");
		btnStatistics.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnStatistics);

		btnEmployee = UIHelper.createStyledButton("Employee Management");
		btnEmployee.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnEmployee);

		btnRoleControl = UIHelper.createStyledButton("Role Control");
		btnRoleControl.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnRoleControl);

		// Container chính dùng CardLayout
		cardLayout = new CardLayout();
		contentContainer = new JPanel(cardLayout);
		contentPanel.add(contentContainer, BorderLayout.CENTER);
		navigation.setLayout(new BorderLayout(0, 0));
		navigation.add(sideBar);
		navigation.add(userInfoPanel, BorderLayout.NORTH);
		var gbl_userInfoPanel = new GridBagLayout();
		gbl_userInfoPanel.columnWidths = new int[] { 65, 160, 0 };
		gbl_userInfoPanel.rowHeights = new int[] { 96, 0 };
		gbl_userInfoPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_userInfoPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		userInfoPanel.setLayout(gbl_userInfoPanel);

		// Dùng jbutton để có thể click vào xem user infor
		userAvatar = new JButton("Avatar");

		userAvatar.setToolTipText("Click here to see your info");
		var gbc_userAvatar = new GridBagConstraints();
		gbc_userAvatar.anchor = GridBagConstraints.WEST;
		gbc_userAvatar.insets = new Insets(0, 0, 0, 5);
		gbc_userAvatar.gridx = 0;
		gbc_userAvatar.gridy = 0;
		userInfoPanel.add(userAvatar, gbc_userAvatar);

		info = new JPanel();
		var gl_info = new GroupLayout(info);
		gl_info.setHorizontalGroup(gl_info.createParallelGroup(Alignment.LEADING).addGap(0, 160, Short.MAX_VALUE));
		gl_info.setVerticalGroup(gl_info.createParallelGroup(Alignment.LEADING).addGap(0, 96, Short.MAX_VALUE));
		info.setLayout(gl_info);
		var gbc_info = new GridBagConstraints();
		gbc_info.anchor = GridBagConstraints.NORTHWEST;
		gbc_info.gridx = 1;
		gbc_info.gridy = 0;
		userInfoPanel.add(info, gbc_info);

		// Medicine Panel
		medicineManagementPanel = new JPanel();
		medicineManagementPanel.setBackground(Color.WHITE);
		medicineManagementPanel.setLayout(new BorderLayout());
		contentContainer.add(medicineManagementPanel, "medicineManagementPanel");

		medicineHeadPanel = new JPanel();
		medicineManagementPanel.add(medicineHeadPanel, BorderLayout.NORTH);
		medicineHeadPanel.setLayout(new BorderLayout(0, 0));

		headerSearchPanel = new JPanel();
		medicineHeadPanel.add(headerSearchPanel, BorderLayout.NORTH);
		headerSearchPanel.setLayout(new BoxLayout(headerSearchPanel, BoxLayout.X_AXIS));

		btnAddMedicine = new JButton("Add medicine");
		headerSearchPanel.add(btnAddMedicine);

		btnNewButton_20 = new JButton("Update medicine");
		headerSearchPanel.add(btnNewButton_20);

		btnNewButton_21 = new JButton("Delete medicine");
		headerSearchPanel.add(btnNewButton_21);

		panel = new JPanel();
		headerSearchPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnSearchMedicine = new JButton("Search");
		panel.add(btnSearchMedicine);

		btnRefresh = new JButton("Refresh");
		headerSearchPanel.add(btnRefresh);

		headerFilterPanel = new JPanel();
		medicineHeadPanel.add(headerFilterPanel, BorderLayout.CENTER);
		headerFilterPanel.setLayout(new BoxLayout(headerFilterPanel, BoxLayout.X_AXIS));

		panel_1 = new JPanel();
		headerFilterPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCategory, BorderLayout.NORTH);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "All types", "Pain relief", "Antipyretic", "Vitamins" }));
		panel_1.add(comboBox, BorderLayout.CENTER);

		panel_2 = new JPanel();
		headerFilterPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		lblOrigin = new JLabel("Origin");
		lblOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblOrigin, BorderLayout.NORTH);

		comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);

		panel_3 = new JPanel();
		headerFilterPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblUnitMeasure = new JLabel("Unit of Measure");
		lblUnitMeasure.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblUnitMeasure, BorderLayout.NORTH);

		comboBox_2 = new JComboBox();
		panel_3.add(comboBox_2, BorderLayout.SOUTH);

		panel_4 = new JPanel();
		headerFilterPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		lblDaysExpiration = new JLabel("Days of Expiration");
		lblDaysExpiration.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblDaysExpiration, BorderLayout.NORTH);

		panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		panel_5.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		btnNewButton_2 = new JButton(">");
		panel_5.add(btnNewButton_2, BorderLayout.EAST);

		medicineDetailPanel = new JPanel();
		medicineManagementPanel.add(medicineDetailPanel, BorderLayout.CENTER);
		medicineDetailPanel.setLayout(new BorderLayout(0, 0));

		lblNewLabel_1 = new JLabel("List of Medicine");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		medicineDetailPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		scrollPane = new JScrollPane();
		medicineDetailPanel.add(scrollPane, BorderLayout.CENTER);

		table_medicines = new JTable();
		scrollPane.setViewportView(table_medicines);

		providerPanel = new JPanel();
		providerPanel.setBackground(new Color(255, 128, 128));
		contentContainer.add(providerPanel, "providerPanel");
		providerPanel.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		providerPanel.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		btnHeaderAddProvider = new JButton("Add provider");
		panel_6.add(btnHeaderAddProvider);

		btnNewButton_22 = new JButton("Update provider");
		panel_6.add(btnNewButton_22);

		btnNewButton_23 = new JButton("Delete provider");
		panel_6.add(btnNewButton_23);

		searchProviderPanel = new JPanel();
		panel_6.add(searchProviderPanel);
		searchProviderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField_2 = new JTextField();
		searchProviderPanel.add(textField_2);
		textField_2.setColumns(10);

		btnHeaderProviderSearch = new JButton("Search");
		searchProviderPanel.add(btnHeaderProviderSearch);

		btnHeaderProviderRefresh = new JButton("Refresh");
		panel_6.add(btnHeaderProviderRefresh);

		panel_7 = new JPanel();
		providerPanel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("List of Provider");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel, BorderLayout.NORTH);

		scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1, BorderLayout.CENTER);

		table = new JTable();
		scrollPane_1.setViewportView(table);

		invoiceManagementPanel = new JPanel();
		invoiceManagementPanel.setBackground(new Color(255, 255, 128));
		contentContainer.add(invoiceManagementPanel, "invoiceManagementPanel");
		invoiceManagementPanel.setLayout(new BorderLayout(0, 0));

		panel_8 = new JPanel();
		invoiceManagementPanel.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new BorderLayout(0, 0));

		panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

		btnNewButton = new JButton("Create New Order");
		panel_10.add(btnNewButton);

		btnNewButton_24 = new JButton("Update order");
		panel_10.add(btnNewButton_24);

		btnNewButton_25 = new JButton("Delete order");
		panel_10.add(btnNewButton_25);

		panel_12 = new JPanel();
		panel_10.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField_3 = new JTextField();
		panel_12.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton_1 = new JButton("Search");
		panel_12.add(btnNewButton_1);

		panel_11 = new JPanel();
		panel_8.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));

		lblNewLabel_2 = new JLabel("Filter");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_2, BorderLayout.NORTH);

		panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.SOUTH);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));

		panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));

		lblNewLabel_3 = new JLabel("Date (From - To)");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblNewLabel_3, BorderLayout.NORTH);

		panel_18 = new JPanel();
		panel_14.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		dateChooser = new JDateChooser();
		panel_18.add(dateChooser);

		dateChooser_1 = new JDateChooser();
		panel_18.add(dateChooser_1);

		panel_16 = new JPanel();
		panel_13.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));

		lblNewLabel_4 = new JLabel("Price (From - To)");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(lblNewLabel_4, BorderLayout.NORTH);

		panel_15 = new JPanel();
		panel_16.add(panel_15, BorderLayout.SOUTH);

		textField_4 = new JTextField();
		panel_15.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		panel_15.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton_3 = new JButton(">");
		panel_13.add(btnNewButton_3);

		panel_9 = new JPanel();
		invoiceManagementPanel.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		lblNewLabel_5 = new JLabel("List of Purchase Order");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_5, BorderLayout.NORTH);

		scrollPane_2 = new JScrollPane();
		panel_9.add(scrollPane_2, BorderLayout.CENTER);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		pharmacyCounterPanel = new JPanel();
		pharmacyCounterPanel.setBackground(new Color(0, 255, 128));
		contentContainer.add(pharmacyCounterPanel, "pharmacyCounterPanel");
		pharmacyCounterPanel.setLayout(new BorderLayout(0, 0));

		panel_17 = new JPanel();
		pharmacyCounterPanel.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new BorderLayout(0, 0));

		panel_20 = new JPanel();
		panel_17.add(panel_20, BorderLayout.NORTH);
		panel_20.setLayout(new BorderLayout(0, 0));

		lblNewLabel_7 = new JLabel("Medicine Detail");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(lblNewLabel_7, BorderLayout.NORTH);

		panel_28 = new JPanel();
		panel_20.add(panel_28, BorderLayout.CENTER);
		panel_28.setLayout(new BorderLayout(0, 0));

		panel_29 = new JPanel();
		panel_28.add(panel_29, BorderLayout.WEST);
		panel_29.setLayout(new GridLayout(1, 0, 0, 0));

		btnNewButton_6 = new JButton("Hình ảnh thuốc");
		panel_29.add(btnNewButton_6);

		panel_30 = new JPanel();
		panel_28.add(panel_30, BorderLayout.CENTER);

		panel_31 = new JPanel();
		panel_31.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_9 = new JLabel("Mã thuốc:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		panel_31.add(lblNewLabel_9);

		textField_6 = new JTextField();
		panel_31.add(textField_6);
		textField_6.setColumns(10);

		panel_32 = new JPanel();
		panel_32.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_10 = new JLabel("Tên thuốc:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		panel_32.add(lblNewLabel_10);

		textField_7 = new JTextField();
		panel_32.add(textField_7);
		textField_7.setColumns(10);

		panel_33 = new JPanel();
		panel_33.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_11 = new JLabel("Thành phần:");
		panel_33.add(lblNewLabel_11);

		textField_8 = new JTextField();
		panel_33.add(textField_8);
		textField_8.setColumns(10);

		panel_34 = new JPanel();
		panel_34.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_12 = new JLabel("Đơn giá:");
		panel_34.add(lblNewLabel_12);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_34.add(textField_9);
		panel_30.setLayout(new GridLayout(0, 1, 0, 0));
		panel_30.add(panel_31);
		panel_30.add(panel_32);
		panel_30.add(panel_33);
		panel_30.add(panel_34);

		panel_21 = new JPanel();
		panel_17.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new BorderLayout(0, 0));

		panel_24 = new JPanel();
		panel_21.add(panel_24, BorderLayout.NORTH);

		panel_26 = new JPanel();
		panel_24.add(panel_26);

		comboBox_3 = new JComboBox();
		panel_26.add(comboBox_3);
		comboBox_3.setModel(
				new DefaultComboBoxModel(new String[] { "All types", "Pain relief", "Antipyretic", "Vitamins" }));

		txtSearch = new JTextField();
		panel_26.add(txtSearch);
		txtSearch.setText("Search...");
		txtSearch.setColumns(10);

		btnNewButton_4 = new JButton("Search");
		panel_26.add(btnNewButton_4);

		panel_27 = new JPanel();
		panel_24.add(panel_27);

		txtAmount = new JTextField();
		panel_27.add(txtAmount);
		txtAmount.setText("Amount");
		txtAmount.setColumns(10);

		btnNewButton_5 = new JButton("Add");
		panel_27.add(btnNewButton_5);

		scrollPane_5 = new JScrollPane();
		panel_21.add(scrollPane_5, BorderLayout.CENTER);

		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);

		panel_19 = new JPanel();
		pharmacyCounterPanel.add(panel_19, BorderLayout.EAST);
		panel_19.setLayout(new BorderLayout(0, 0));

		panel_22 = new JPanel();
		panel_19.add(panel_22, BorderLayout.NORTH);
		panel_22.setLayout(new BorderLayout(0, 0));

		lblNewLabel_6 = new JLabel("Cart");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(lblNewLabel_6, BorderLayout.NORTH);

		scrollPane_3 = new JScrollPane();
		panel_22.add(scrollPane_3, BorderLayout.CENTER);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);

		btnNewButton_26 = new JButton("Delete");
		panel_22.add(btnNewButton_26, BorderLayout.SOUTH);

		panel_23 = new JPanel();
		panel_19.add(panel_23, BorderLayout.CENTER);
		panel_23.setLayout(new BorderLayout(0, 0));

		lblNewLabel_8 = new JLabel("Invoice");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_23.add(lblNewLabel_8, BorderLayout.NORTH);

		panel_25 = new JPanel();
		panel_25.setLayout(new GridLayout(0, 2, 0, 0));
		panel_23.add(panel_25, BorderLayout.CENTER);

		lblNewLabel_13 = new JLabel("Mã hóa đơn");
		panel_25.add(lblNewLabel_13);

		textField_10 = new JTextField();
		panel_25.add(textField_10);
		textField_10.setColumns(10);

		lblNewLabel_14 = new JLabel("Số điện thoại");
		panel_25.add(lblNewLabel_14);

		textField_11 = new JTextField();
		panel_25.add(textField_11);
		textField_11.setColumns(10);

		lblNewLabel_15 = new JLabel("Tên khách hàng");
		panel_25.add(lblNewLabel_15);

		textField_12 = new JTextField();
		panel_25.add(textField_12);
		textField_12.setColumns(10);

		lblNewLabel_16 = new JLabel("Tổng hóa đơn");
		panel_25.add(lblNewLabel_16);

		textField_13 = new JTextField();
		panel_25.add(textField_13);
		textField_13.setColumns(10);

		btnNewButton_7 = new JButton("HỦY BỎ");
		panel_25.add(btnNewButton_7);

		btnNewButton_8 = new JButton("IN HÓA ĐƠN");
		panel_25.add(btnNewButton_8);

		customerPanel = new JPanel();
		customerPanel.setBackground(new Color(128, 255, 255));
		contentContainer.add(customerPanel, "customerPanel");
		customerPanel.setLayout(new BorderLayout(0, 0));

		panel_35 = new JPanel();
		customerPanel.add(panel_35, BorderLayout.NORTH);
		panel_35.setLayout(new BoxLayout(panel_35, BoxLayout.X_AXIS));

		btnNewButton_9 = new JButton("Add new customer");
		panel_35.add(btnNewButton_9);

		btnNewButton_16 = new JButton("Update customer");
		panel_35.add(btnNewButton_16);

		btnNewButton_17 = new JButton("Delete customer");
		panel_35.add(btnNewButton_17);

		panel_37 = new JPanel();
		panel_35.add(panel_37);

		textField_14 = new JTextField();
		panel_37.add(textField_14);
		textField_14.setColumns(10);

		btnNewButton_11 = new JButton("Search");
		panel_37.add(btnNewButton_11);

		btnNewButton_10 = new JButton("Refresh");
		panel_35.add(btnNewButton_10);

		panel_36 = new JPanel();
		customerPanel.add(panel_36, BorderLayout.CENTER);
		panel_36.setLayout(new BorderLayout(0, 0));

		lblNewLabel_17 = new JLabel("List of Customer");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_36.add(lblNewLabel_17, BorderLayout.NORTH);

		scrollPane_4 = new JScrollPane();
		panel_36.add(scrollPane_4, BorderLayout.CENTER);

		table_1 = new JTable();
		scrollPane_4.setViewportView(table_1);

		statisticsPanel = new JPanel();
		statisticsPanel.setBackground(new Color(0, 128, 255));
		contentContainer.add(statisticsPanel, "statisticsPanel");

		lblNewLabel_20 = new JLabel(
				"Thiết kế sau\r\nDoanh thu\r\nThuốc bán chạy\r\nTồn kho\r\nThống kê khách hàng\r\nThống kê theo nhân viên\r\nHiển thị biểu đồ\r\n\r\n");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		statisticsPanel.add(lblNewLabel_20);

		employeeManagementPanel = new JPanel();
		employeeManagementPanel.setBackground(new Color(255, 128, 192));
		contentContainer.add(employeeManagementPanel, "employeeManagementPanel");
		employeeManagementPanel.setLayout(new BorderLayout(0, 0));

		panel_38 = new JPanel();
		employeeManagementPanel.add(panel_38, BorderLayout.NORTH);
		panel_38.setLayout(new BoxLayout(panel_38, BoxLayout.X_AXIS));

		btnNewButton_12 = new JButton("Add new employee");
		panel_38.add(btnNewButton_12);

		btnNewButton_18 = new JButton("Update employee");
		panel_38.add(btnNewButton_18);

		btnNewButton_19 = new JButton("Delete employee");
		panel_38.add(btnNewButton_19);

		panel_40 = new JPanel();
		panel_38.add(panel_40);

		textField_15 = new JTextField();
		panel_40.add(textField_15);
		textField_15.setColumns(10);

		btnNewButton_14 = new JButton("Search");
		panel_40.add(btnNewButton_14);

		btnNewButton_13 = new JButton("Refresh");
		panel_38.add(btnNewButton_13);

		panel_39 = new JPanel();
		employeeManagementPanel.add(panel_39, BorderLayout.CENTER);
		panel_39.setLayout(new BorderLayout(0, 0));

		lblNewLabel_18 = new JLabel("List of Employee");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_39.add(lblNewLabel_18, BorderLayout.NORTH);

		scrollPane_6 = new JScrollPane();
		panel_39.add(scrollPane_6, BorderLayout.CENTER);

		table_4 = new JTable();
		scrollPane_6.setViewportView(table_4);

		roleControlPanel = new JPanel();
		roleControlPanel.setBackground(new Color(255, 255, 255));
		contentContainer.add(roleControlPanel, "roleControlPanel");
		roleControlPanel.setLayout(new BorderLayout(0, 0));

		lblNewLabel_19 = new JLabel("Role Management");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		roleControlPanel.add(lblNewLabel_19, BorderLayout.NORTH);

		btnNewButton_15 = new JButton("Update role");
		roleControlPanel.add(btnNewButton_15, BorderLayout.WEST);

		scrollPane_7 = new JScrollPane();
		roleControlPanel.add(scrollPane_7, BorderLayout.CENTER);

		table_6 = new JTable();
		scrollPane_7.setViewportView(table_6);

		loadDataToTable();

		// Hiển thị các thành phần tùy vào role
		if ("1".equals(role) || "2".equals(role)) {
			// Admin Dashboard
//			var adminLabel = new JLabel("Welcome, Admin! Here are your management tools.");
//			adminLabel.setFont(new Font("Arial", Font.BOLD, 18));
//			contentPanel.add(adminLabel, BorderLayout.CENTER);
			medicineManagementPanel.setVisible(true);

			// Bạn có thể thêm các công cụ quản lý cho Admin tại đây, ví dụ: quản lý người
			// dùng, báo cáo, v.v.
		}
	}

	private void btnMedicineActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "medicineManagementPanel");
	}

	public static void main(String[] args) {

		String[] lookAndFeels = { "javax.swing.plaf.nimbus.NimbusLookAndFeel", "com.formdev.flatlaf.FlatLightLaf",
				"com.sun.java.swing.plaf.windows.WindowsLookAndFeel", "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
				UIManager.getSystemLookAndFeelClassName() };

		for (String lookAndFeel : lookAndFeels) {
			try {
				UIManager.setLookAndFeel(lookAndFeel);
				break; // Chọn Look and Feel đầu tiên hợp lệ
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Dùng một ví dụ để khởi chạy giao diện Main với role là Admin
		EventQueue.invokeLater(() -> {
			try {
				var frame = new Main("1"); // Role 1 cho Admin, bạn có thể thay đổi theo yêu cầu
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	protected void btnProviderActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "providerPanel");
	}

	protected void btnInvoiceManagementActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "invoiceManagementPanel");
	}

	protected void btnPharmacyCounterActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "pharmacyCounterPanel");
	}

	protected void btnCustomerActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "customerPanel");
	}

	protected void btnStatisticsActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "statisticsPanel");
	}

	protected void btnEmployeeActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "employeeManagementPanel");
	}

	protected void btnRoleControlActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "roleControlPanel");
	}

	private void loadDataToTable() {
		// Tạo model cho bảng
		var model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Tên thuốc");
		model.addColumn("Loại");
		model.addColumn("Giá");
		model.addColumn("Số lượng");
		model.addColumn("Ngày sản xuất");
		model.addColumn("Ngày hết hạn");

		// Khởi tạo DAO và lấy dữ liệu
		var dao = new MedicinesDao();
		dao.select().forEach(medicine -> {
			model.addRow(new Object[] { medicine.getId(), medicine.getMedicine_name(), medicine.getCategory_id(),
					medicine.getPrice(), medicine.getStock(), medicine.getManufacturing_date(),
					medicine.getExpiry_date() });
		});

		// Gắn model vào bảng
		table_medicines.setModel(model);
	}

}