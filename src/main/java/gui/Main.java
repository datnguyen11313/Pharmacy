package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

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
	private JButton btnMedicine;
	private JButton btnPurchaseOrder;
	private JButton btnProvider_1;
	private JSeparator separator;
	private JButton btnCustomer;
	private JButton btnInvoice;
	private JButton btnStatistics;
	private JSeparator separator_1;
	private JButton btnEmployee;
	private JButton btnRoleControl;
	private JButton btnLogout;
	private JPanel medicinePanel;
	private JPanel medicineHeadPanel;
	private JPanel medicineDetailPanel;
	private JPanel contentContainer;
	private JPanel providerPanel;
	private JPanel purchaseOrderPanel;
	private JPanel customerPanel;
	private JPanel invoicePanel;
	private JPanel statisticsPanel;
	private JPanel employeeManagementPanel;
	private JPanel roleControlPanel;
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
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;

	public Main(String role) {
		this.role = role; // Lưu role của người dùng
		setTitle("Main Dashboard");
		setBounds(100, 100, 962, 663);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());

		navigation = new JPanel();
		navigation.setBackground(new Color(133, 250, 139));
		contentPanel.add(navigation, BorderLayout.WEST);

		userInfoPanel = new JPanel();

		sideBar = new JPanel();
		var gl_navigation = new GroupLayout(navigation);
		gl_navigation.setHorizontalGroup(gl_navigation.createParallelGroup(Alignment.LEADING)
				.addComponent(sideBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
				.addComponent(userInfoPanel, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE));
		gl_navigation.setVerticalGroup(gl_navigation.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_navigation.createSequentialGroup()
						.addComponent(userInfoPanel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(sideBar, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)));
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

		btnMedicine = new JButton("Medicine");
		btnMedicine.addActionListener(this::btnMedicineActionPerformed);
		btnMedicine.setHorizontalAlignment(SwingConstants.LEFT);
		btnMedicine.setPreferredSize(new java.awt.Dimension(150, 40));

		contentScrollPaneSideBar.add(btnMedicine);

		btnProvider_1 = new JButton("Provider");
		btnProvider_1.addActionListener(this::btnProvider_1ActionPerformed);
		btnProvider_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnProvider_1.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnProvider_1);

		btnPurchaseOrder = new JButton("Purchase Order");
		btnPurchaseOrder.addActionListener(this::btnPurchaseOrderActionPerformed);
		btnPurchaseOrder.setHorizontalAlignment(SwingConstants.LEFT);
		btnPurchaseOrder.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnPurchaseOrder);

		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(150, 2));

		contentScrollPaneSideBar.add(separator);

		btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(this::btnCustomerActionPerformed);
		btnCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomer.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnCustomer);

		btnInvoice = new JButton("Invoice");
		btnInvoice.addActionListener(this::btnInvoiceActionPerformed);
		btnInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoice.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnInvoice);

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
		userInfoPanel.setLayout(new BorderLayout(0, 0));

		// Container chính dùng CardLayout
		cardLayout = new CardLayout();
		contentContainer = new JPanel(cardLayout);
		contentPanel.add(contentContainer, BorderLayout.CENTER);

		// Dùng jbutton để có thể click vào xem user infor
		userAvatar = new JButton("Avatar");

		userAvatar.setToolTipText("Click here to see your info");
		userInfoPanel.add(userAvatar, BorderLayout.WEST);

		info = new JPanel();
		userInfoPanel.add(info, BorderLayout.CENTER);
		var gl_info = new GroupLayout(info);
		gl_info.setHorizontalGroup(gl_info.createParallelGroup(Alignment.LEADING).addGap(0, 160, Short.MAX_VALUE));
		gl_info.setVerticalGroup(gl_info.createParallelGroup(Alignment.LEADING).addGap(0, 96, Short.MAX_VALUE));
		info.setLayout(gl_info);
		navigation.setLayout(gl_navigation);

		// Medicine Panel
		medicinePanel = new JPanel();
		medicinePanel.setBackground(Color.WHITE);
		medicinePanel.setLayout(new BorderLayout());
		contentContainer.add(medicinePanel, "medicinePanel");

		medicineHeadPanel = new JPanel();
		medicinePanel.add(medicineHeadPanel, BorderLayout.NORTH);
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
		medicinePanel.add(medicineDetailPanel, BorderLayout.CENTER);
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

		purchaseOrderPanel = new JPanel();
		purchaseOrderPanel.setBackground(new Color(255, 255, 128));
		contentContainer.add(purchaseOrderPanel, "purchaseOrderPanel");
		purchaseOrderPanel.setLayout(new BorderLayout(0, 0));

		panel_8 = new JPanel();
		purchaseOrderPanel.add(panel_8, BorderLayout.NORTH);
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

		lblNewLabel_2 = new JLabel("New label");
		panel_11.add(lblNewLabel_2, BorderLayout.NORTH);

		panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.SOUTH);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));

		panel_14 = new JPanel();
		panel_13.add(panel_14);

		panel_15 = new JPanel();
		panel_13.add(panel_15);

		panel_16 = new JPanel();
		panel_13.add(panel_16);

		panel_17 = new JPanel();
		panel_13.add(panel_17);

		panel_9 = new JPanel();
		purchaseOrderPanel.add(panel_9, BorderLayout.CENTER);

		customerPanel = new JPanel();
		customerPanel.setBackground(new Color(128, 255, 128));
		contentContainer.add(customerPanel, "customerPanel");

		invoicePanel = new JPanel();
		invoicePanel.setBackground(new Color(128, 255, 255));
		contentContainer.add(invoicePanel, "invoicePanel");

		statisticsPanel = new JPanel();
		statisticsPanel.setBackground(new Color(0, 128, 255));
		contentContainer.add(statisticsPanel, "statisticsPanel");

		employeeManagementPanel = new JPanel();
		employeeManagementPanel.setBackground(new Color(255, 128, 192));
		contentContainer.add(employeeManagementPanel, "employeeManagementPanel");

		roleControlPanel = new JPanel();
		roleControlPanel.setBackground(new Color(255, 0, 128));
		contentContainer.add(roleControlPanel, "roleControlPanel");

		// Hiển thị các thành phần tùy vào role
		if ("1".equals(role) || "2".equals(role)) {
			// Admin Dashboard
//			var adminLabel = new JLabel("Welcome, Admin! Here are your management tools.");
//			adminLabel.setFont(new Font("Arial", Font.BOLD, 18));
//			contentPanel.add(adminLabel, BorderLayout.CENTER);
			medicinePanel.setVisible(true);

			// Bạn có thể thêm các công cụ quản lý cho Admin tại đây, ví dụ: quản lý người
			// dùng, báo cáo, v.v.
		}
	}

	private void btnMedicineActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "medicinePanel");
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

	protected void btnProvider_1ActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "providerPanel");
	}

	protected void btnPurchaseOrderActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "purchaseOrderPanel");
	}

	protected void btnCustomerActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "customerPanel");
	}

	protected void btnInvoiceActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "invoicePanel");
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