package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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

import com.toedter.calendar.JDateChooser;

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
	private JTable table_1;
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

	public Main(String role) {
		this.role = role; // Lưu role của người dùng
		setTitle("Main Dashboard");
		setBounds(100, 100, 1063, 791);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());

		navigation = new JPanel();
		navigation.setBackground(new Color(133, 250, 139));
		contentPanel.add(navigation, BorderLayout.WEST);
		navigation.setPreferredSize(new Dimension(200, navigation.getHeight()));

		userInfoPanel = new JPanel();

		sideBar = new JPanel();
		sideBar.setLayout(new BorderLayout(0, 0));

		panelLogout = new JPanel();
		sideBar.add(panelLogout, BorderLayout.SOUTH);

		btnLogout = new JButton("Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setPreferredSize(new Dimension(150, 40));
		panelLogout.add(btnLogout);

		scrollPaneSideBar = new JScrollPane();
		sideBar.add(scrollPaneSideBar, BorderLayout.CENTER);

		contentScrollPaneSideBar = new JPanel();
		scrollPaneSideBar.setViewportView(contentScrollPaneSideBar);
		contentScrollPaneSideBar.setPreferredSize(new java.awt.Dimension(150, 46));

		btnMedicineManagement = new JButton("Medicine Management");
		btnMedicineManagement.addActionListener(this::btnMedicineActionPerformed);

		btnPharmacyCounter = new JButton("Pharmacy Counter");
		btnPharmacyCounter.addActionListener(this::btnPharmacyCounterActionPerformed);
		btnPharmacyCounter.setHorizontalAlignment(SwingConstants.LEFT);
		btnPharmacyCounter.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnPharmacyCounter);
		btnMedicineManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btnMedicineManagement.setPreferredSize(new java.awt.Dimension(150, 40));
		btnPharmacyCounter.setPreferredSize(new java.awt.Dimension(150, 80));

		contentScrollPaneSideBar.add(btnMedicineManagement);

		btnProvider = new JButton("Provider");
		btnProvider.addActionListener(this::btnProviderActionPerformed);
		btnProvider.setHorizontalAlignment(SwingConstants.LEFT);
		btnProvider.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnProvider);

		btnInvoiceManagement = new JButton("Invoice Management");
		btnInvoiceManagement.addActionListener(this::btnInvoiceManagementActionPerformed);
		btnInvoiceManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoiceManagement.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnInvoiceManagement);

		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(150, 2));

		contentScrollPaneSideBar.add(separator);

		btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(this::btnCustomerActionPerformed);
		btnCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomer.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnCustomer);

		btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(this::btnStatisticsActionPerformed);
		btnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistics.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnStatistics);

		separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(150, 2));
		contentScrollPaneSideBar.add(separator_1);

		btnEmployee = new JButton("Employee Magament");
		btnEmployee.addActionListener(this::btnEmployeeActionPerformed);
		btnEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployee.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnEmployee);

		btnRoleControl = new JButton("Role Control");
		btnRoleControl.addActionListener(this::btnRoleControlActionPerformed);
		btnRoleControl.setHorizontalAlignment(SwingConstants.LEFT);
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

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		providerPanel = new JPanel();
		providerPanel.setBackground(new Color(255, 128, 128));
		contentContainer.add(providerPanel, "providerPanel");
		providerPanel.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		providerPanel.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		btnHeaderAddProvider = new JButton("Add provider");
		panel_6.add(btnHeaderAddProvider);

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

		lblNewLabel_9 = new JLabel("Mã thuốc:");
		panel_31.add(lblNewLabel_9);

		textField_6 = new JTextField();
		panel_31.add(textField_6);
		textField_6.setColumns(10);

		panel_32 = new JPanel();

		lblNewLabel_10 = new JLabel("Tên thuốc:");
		panel_32.add(lblNewLabel_10);

		textField_7 = new JTextField();
		panel_32.add(textField_7);
		textField_7.setColumns(10);

		panel_33 = new JPanel();

		lblNewLabel_11 = new JLabel("Thành phần:");
		panel_33.add(lblNewLabel_11);

		textField_8 = new JTextField();
		panel_33.add(textField_8);
		textField_8.setColumns(10);

		panel_34 = new JPanel();

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

		panel_23 = new JPanel();
		panel_19.add(panel_23, BorderLayout.CENTER);
		panel_23.setLayout(new BorderLayout(0, 0));

		lblNewLabel_8 = new JLabel("Invoice");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_23.add(lblNewLabel_8, BorderLayout.NORTH);

		panel_25 = new JPanel();
		panel_23.add(panel_25, BorderLayout.CENTER);

		customerPanel = new JPanel();
		customerPanel.setBackground(new Color(128, 255, 255));
		contentContainer.add(customerPanel, "customerPanel");

		statisticsPanel = new JPanel();
		statisticsPanel.setBackground(new Color(0, 128, 255));
		contentContainer.add(statisticsPanel, "statisticsPanel");

		employeeManagementPanel = new JPanel();
		employeeManagementPanel.setBackground(new Color(255, 128, 192));
		contentContainer.add(employeeManagementPanel, "employeeManagementPanel");

		roleControlPanel = new JPanel();
		roleControlPanel.setBackground(new Color(128, 0, 64));
		contentContainer.add(roleControlPanel, "roleControlPanel");

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
}