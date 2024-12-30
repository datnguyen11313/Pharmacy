package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.MedicinesDao;
import utils.ButtonRenderer;
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
	private JButton btnPharmacyCounter;
	private JButton btnLogout;
	private JPanel medicineManagementPanel;
	private JPanel medicineHeadPanel;
	private JPanel medicineDetailPanel;
	private JPanel roleControlPanel;
	private JPanel contentContainer;
	private JPanel providerPanel;
	private JPanel invoiceManagementPanel;
	private CardLayout cardLayout;
	private JPanel headerSearchPanel;
	private JPanel headerFilterPanel;
	private JButton btnAddMedicine;
	private JPanel panelSearch;
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
	private JTextField textSearch;
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
	private JPanel counterHeader;
	private JPanel panel_19;
	private JPanel medicineDetail;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane_3;
	private JTable table_3;
	private JLabel lblNewLabel_7;
	private JPanel panel_24;
	private JScrollPane scrollPane_Counter;
	private JTable table_Counter;
	private JLabel lblNewLabel_8;
	private JPanel panel_25;
	private JComboBox comboBox_3;
	private JTextField txtSearch;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JTextField txtAmount;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_CounterInfo;
	private JPanel panel_CounterImage;
	private JPanel panel_CounterInfoDetail;
	private JButton btnNewButton_6;
	private JLabel lblNewLabel_9;
	private JTextField medicineId;
	private JPanel panel_31;
	private JLabel lblNewLabel_10;
	private JTextField medicineNameInfo;
	private JPanel panel_32;
	private JLabel lblNewLabel_11;
	private JTextField unitMeasure;
	private JPanel panel_33;
	private JPanel panel_34;
	private JLabel lblNewLabel_12;
	private JTextField price;
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
	private JLabel lblNewLabel_20;
	private JButton btnNewButton_16;
	private JButton btnNewButton_17;
	private JButton btnNewButton_18;
	private JButton btnNewButton_19;
	private JButton btnUpdateMedicine;
	private JButton btnDeleteMedicine;
	private JButton btnNewButton_22;
	private JButton btnNewButton_23;
	private JButton btnNewButton_24;
	private JButton btnNewButton_25;
	private JButton btnNewButton_26;
	private JButton btnMedicineManagement;
	private JButton btnProvider;
	private JButton btnInvoiceManagement;
	private JButton btnCustomer;
	private JButton btnStatistics;
	private JButton btnEmployee;
	private JButton btnRoleControl;
	private JLabel lblRole;
	private JLabel lblUserId;
	private JLabel lblNewLabel_19;
	private JScrollPane scrollPane_7;

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
		userInfoPanel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
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
		btnPharmacyCounter.addActionListener(this::btnPharmacyCounterActionPerformed);
		btnPharmacyCounter.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPharmacyCounter.setVerticalTextPosition(SwingConstants.CENTER);
		btnPharmacyCounter.setPreferredSize(new Dimension(180, 150));
		contentScrollPaneSideBar.add(btnPharmacyCounter);

		btnMedicineManagement = new JButton("Medicine Management");
		btnMedicineManagement.addActionListener(this::btnMedicineManagementActionPerformed);
		contentScrollPaneSideBar.add(btnMedicineManagement);
		UIHelper.styleButton(btnMedicineManagement); // Áp dụng style từ UIHelper

		btnProvider = new JButton("Provider");
		btnProvider.addActionListener(this::btnProviderActionPerformed);
		contentScrollPaneSideBar.add(btnProvider);
		UIHelper.styleButton(btnProvider); // Áp dụng style từ UIHelper

		btnInvoiceManagement = new JButton("Invoice Management");
		btnInvoiceManagement.addActionListener(this::btnInvoiceManagementActionPerformed);
		contentScrollPaneSideBar.add(btnInvoiceManagement);
		UIHelper.styleButton(btnInvoiceManagement); // Áp dụng style từ UIHelper

		btnCustomer = new JButton("Customer Management");
		btnCustomer.addActionListener(this::btnCustomerActionPerformed);
		contentScrollPaneSideBar.add(btnCustomer);
		UIHelper.styleButton(btnCustomer); // Áp dụng style từ UIHelper

		btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(this::btnStatisticsActionPerformed);
		contentScrollPaneSideBar.add(btnStatistics);
		UIHelper.styleButton(btnStatistics); // Áp dụng style từ UIHelper

		btnEmployee = new JButton("Employee Management");
		btnEmployee.addActionListener(this::btnEmployeeActionPerformed);
		contentScrollPaneSideBar.add(btnEmployee);
		UIHelper.styleButton(btnEmployee); // Áp dụng style từ UIHelper

		btnRoleControl = new JButton("Role Control");
		btnRoleControl.addActionListener(this::btnRoleControlActionPerformed);
		contentScrollPaneSideBar.add(btnRoleControl);
		UIHelper.styleButton(btnRoleControl); // Áp dụng style từ UIHelper

		// Container chính dùng CardLayout
		cardLayout = new CardLayout();
		contentContainer = new JPanel(cardLayout);
		contentPanel.add(contentContainer, BorderLayout.CENTER);
		navigation.setLayout(new BorderLayout(0, 0));
		navigation.add(sideBar);
		navigation.add(userInfoPanel, BorderLayout.NORTH);
		userInfoPanel.setLayout(new GridLayout(0, 2, 0, 0));

		// Dùng jbutton để có thể click vào xem user infor
		userAvatar = new JButton("Avatar");

		userAvatar.setToolTipText("Click here to see your info");
		userInfoPanel.add(userAvatar);

		info = new JPanel();
		userInfoPanel.add(info);
		info.setLayout(new GridLayout(0, 1, 0, 0));
		info.setBorder(new EmptyBorder(5, 5, 5, 5));

		lblRole = new JLabel("Role:");
		info.add(lblRole);

		lblUserId = new JLabel("ID:");
		info.add(lblUserId);

		pharmacyCounterPanel = new JPanel();
		pharmacyCounterPanel.setBackground(new Color(0, 255, 128));
		contentContainer.add(pharmacyCounterPanel, "pharmacyCounterPanel");
		pharmacyCounterPanel.setLayout(new BorderLayout(0, 0));

		counterHeader = new JPanel();
		pharmacyCounterPanel.add(counterHeader, BorderLayout.CENTER);
		counterHeader.setLayout(new BorderLayout(0, 0));

		medicineDetail = new JPanel();
		counterHeader.add(medicineDetail, BorderLayout.NORTH);
		medicineDetail.setLayout(new BorderLayout(0, 0));

		lblNewLabel_7 = new JLabel("Medicine Detail");
		lblNewLabel_7.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		medicineDetail.add(lblNewLabel_7, BorderLayout.NORTH);
		lblNewLabel_7.setBorder(new EmptyBorder(10, 0, 10, 0));

		panel_CounterInfo = new JPanel();
		panel_CounterInfo.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		medicineDetail.add(panel_CounterInfo, BorderLayout.CENTER);
		panel_CounterInfo.setLayout(new BorderLayout(0, 0));

		panel_CounterImage = new JPanel();
		panel_CounterInfo.add(panel_CounterImage, BorderLayout.WEST);
		panel_CounterImage.setLayout(new GridLayout(1, 0, 0, 0));

		btnNewButton_6 = new JButton("Hình ảnh thuốc");
		panel_CounterImage.add(btnNewButton_6);

		panel_CounterInfoDetail = new JPanel();
		panel_CounterInfo.add(panel_CounterInfoDetail, BorderLayout.CENTER);
		panel_CounterInfoDetail.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel_31 = new JPanel();
		panel_31.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_9 = new JLabel("Mã thuốc:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		panel_31.add(lblNewLabel_9);

		medicineId = new JTextField();
		panel_31.add(medicineId);
		medicineId.setColumns(10);

		panel_32 = new JPanel();
		panel_32.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_10 = new JLabel("Tên thuốc:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		panel_32.add(lblNewLabel_10);

		medicineNameInfo = new JTextField();
		panel_32.add(medicineNameInfo);
		medicineNameInfo.setColumns(10);

		panel_33 = new JPanel();
		panel_33.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_11 = new JLabel("Đơn vị tính:");
		panel_33.add(lblNewLabel_11);

		unitMeasure = new JTextField();
		panel_33.add(unitMeasure);
		unitMeasure.setColumns(10);

		panel_34 = new JPanel();
		panel_34.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_12 = new JLabel("Đơn giá:");
		panel_34.add(lblNewLabel_12);

		price = new JTextField();
		price.setColumns(10);
		panel_34.add(price);
		panel_CounterInfoDetail.setLayout(new GridLayout(0, 1, 0, 0));
		panel_CounterInfoDetail.add(panel_31);
		panel_CounterInfoDetail.add(panel_32);
		panel_CounterInfoDetail.add(panel_33);
		panel_CounterInfoDetail.add(panel_34);

		panel_21 = new JPanel();
		counterHeader.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new BorderLayout(0, 0));

		panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
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

		scrollPane_Counter = new JScrollPane();
		scrollPane_Counter.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_21.add(scrollPane_Counter, BorderLayout.CENTER);

		table_Counter = new JTable();

		scrollPane_Counter.setViewportView(table_Counter);

		table_Counter.setSelectionBackground(new Color(15, 240, 172)); // Màu nền khi highlight
		table_Counter.setSelectionForeground(Color.BLACK); // Màu chữ khi highlight

		table_Counter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				var row = table_Counter.rowAtPoint(e.getPoint());
				table_Counter.setRowSelectionInterval(row, row); // Highlight dòng
			}

			@Override
			public void mouseExited(MouseEvent e) {
				table_Counter.clearSelection(); // Bỏ highlight
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				table_CounterMouseClicked(e);
			}
		});

		table_Counter.addMouseMotionListener(new MouseMotionAdapter() {

			private int lastRow = -1; // Biến lưu chỉ số dòng được highlight trước đó

			@Override
			public void mouseMoved(MouseEvent e) {
				var row = table_Counter.rowAtPoint(e.getPoint());
				if (row != -1 && row != lastRow) { // Kiểm tra dòng hiện tại có khác dòng trước đó không
					table_Counter.setRowSelectionInterval(row, row);
					lastRow = row;
				}
			}

		});

		panel_19 = new JPanel();
		pharmacyCounterPanel.add(panel_19, BorderLayout.EAST);
		panel_19.setLayout(new BorderLayout(0, 0));

		panel_22 = new JPanel();
		panel_19.add(panel_22, BorderLayout.NORTH);
		panel_22.setLayout(new BorderLayout(0, 0));

		lblNewLabel_6 = new JLabel("Cart");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(lblNewLabel_6, BorderLayout.NORTH);

		scrollPane_3 = new JScrollPane();
		panel_22.add(scrollPane_3, BorderLayout.CENTER);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);

		btnNewButton_26 = new JButton("Delete");
		btnNewButton_26.setBackground(new Color(255, 0, 0));
		panel_22.add(btnNewButton_26, BorderLayout.SOUTH);

		panel_23 = new JPanel();
		panel_19.add(panel_23, BorderLayout.CENTER);
		panel_23.setLayout(new BorderLayout(0, 0));

		lblNewLabel_8 = new JLabel("Invoice");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.BOLD, 14));
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
		btnNewButton_7.setBackground(new Color(255, 0, 0));
		panel_25.add(btnNewButton_7);

		btnNewButton_8 = new JButton("IN HÓA ĐƠN");
		btnNewButton_8.setBackground(new Color(15, 240, 172));
		panel_25.add(btnNewButton_8);

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
		headerSearchPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		btnAddMedicine = new JButton("Add medicine");
		btnAddMedicine.setBackground(new Color(15, 240, 172));
		headerSearchPanel.add(btnAddMedicine);

		btnUpdateMedicine = new JButton("Update medicine");
		btnUpdateMedicine.setBackground(new Color(2, 209, 253));
		headerSearchPanel.add(btnUpdateMedicine);

		btnDeleteMedicine = new JButton("Delete medicine");
		btnDeleteMedicine.setBackground(new Color(255, 0, 0));
		headerSearchPanel.add(btnDeleteMedicine);

		panelSearch = new JPanel();
		headerSearchPanel.add(panelSearch);
		panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.X_AXIS));
		panelSearch.setBorder(new EmptyBorder(0, 100, 0, 100));

		textSearch = new JTextField();
		panelSearch.add(textSearch);
		textSearch.setColumns(10);
		textSearch.setPreferredSize(new Dimension(400, 30));

		btnSearchMedicine = new JButton("Search");
		panelSearch.add(btnSearchMedicine);

		btnRefresh = new JButton("Refresh");
		headerSearchPanel.add(btnRefresh);

		headerFilterPanel = new JPanel();
		medicineHeadPanel.add(headerFilterPanel, BorderLayout.CENTER);
		headerFilterPanel.setLayout(new BoxLayout(headerFilterPanel, BoxLayout.X_AXIS));
		headerFilterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		headerFilterPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(new EmptyBorder(0, 20, 0, 20));

		lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCategory, BorderLayout.NORTH);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "All types", "Pain relief", "Antipyretic", "Vitamins" }));
		panel_1.add(comboBox, BorderLayout.CENTER);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerFilterPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setBorder(new EmptyBorder(0, 20, 0, 20));

		lblOrigin = new JLabel("Origin");
		lblOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblOrigin, BorderLayout.NORTH);

		comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);

		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerFilterPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBorder(new EmptyBorder(0, 20, 0, 20));

		lblUnitMeasure = new JLabel("Unit of Measure");
		lblUnitMeasure.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblUnitMeasure, BorderLayout.NORTH);

		comboBox_2 = new JComboBox();
		panel_3.add(comboBox_2, BorderLayout.SOUTH);

		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerFilterPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.setBorder(new EmptyBorder(0, 20, 0, 20));

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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		panel_6.setBorder(new EmptyBorder(10, 0, 10, 0));

		btnHeaderAddProvider = new JButton("Add provider");
		btnHeaderAddProvider.setBackground(new Color(15, 240, 172));
		panel_6.add(btnHeaderAddProvider);

		btnNewButton_22 = new JButton("Update provider");
		btnNewButton_22.setBackground(new Color(0, 128, 255));
		panel_6.add(btnNewButton_22);

		btnNewButton_23 = new JButton("Delete provider");
		btnNewButton_23.setBackground(new Color(255, 0, 0));
		panel_6.add(btnNewButton_23);

		searchProviderPanel = new JPanel();
		panel_6.add(searchProviderPanel);
		searchProviderPanel.setLayout(new BoxLayout(searchProviderPanel, BoxLayout.X_AXIS));
		searchProviderPanel.setBorder(new EmptyBorder(0, 200, 0, 200));

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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		panel_8.setBorder(new EmptyBorder(10, 0, 10, 0));

		panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

		btnNewButton = new JButton("Create New Order");
		btnNewButton.setBackground(new Color(15, 240, 172));
		panel_10.add(btnNewButton);

		btnNewButton_24 = new JButton("Update order");
		btnNewButton_24.setBackground(new Color(0, 128, 255));
		panel_10.add(btnNewButton_24);

		btnNewButton_25 = new JButton("Delete order");
		btnNewButton_25.setBackground(new Color(255, 0, 0));
		panel_10.add(btnNewButton_25);

		panel_12 = new JPanel();
		panel_10.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		panel_12.setBorder(new EmptyBorder(0, 200, 0, 200));

		textField_3 = new JTextField();
		panel_12.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton_1 = new JButton("Search");
		panel_12.add(btnNewButton_1);

		panel_11 = new JPanel();
		panel_8.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));

		lblNewLabel_2 = new JLabel("Filter");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_2, BorderLayout.NORTH);
		lblNewLabel_2.setBorder(new EmptyBorder(10, 0, 10, 0));

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
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));
		panel_18.setBorder(new EmptyBorder(0, 30, 0, 30));

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
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		panel_15.setBorder(new EmptyBorder(0, 30, 0, 30));

		textField_4 = new JTextField();
		panel_15.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		panel_15.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton_3 = new JButton(">");
		panel_13.add(btnNewButton_3);
		panelSearch.setBorder(new EmptyBorder(0, 30, 0, 30));

		panel_9 = new JPanel();
		invoiceManagementPanel.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		lblNewLabel_5 = new JLabel("List of Purchase Order");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_5, BorderLayout.NORTH);

		scrollPane_2 = new JScrollPane();
		panel_9.add(scrollPane_2, BorderLayout.CENTER);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		customerPanel = new JPanel();
		customerPanel.setBackground(new Color(128, 255, 255));
		contentContainer.add(customerPanel, "customerPanel");
		customerPanel.setLayout(new BorderLayout(0, 0));

		panel_35 = new JPanel();
		customerPanel.add(panel_35, BorderLayout.NORTH);
		panel_35.setLayout(new BoxLayout(panel_35, BoxLayout.X_AXIS));
		panel_35.setBorder(new EmptyBorder(10, 0, 10, 0));

		btnNewButton_9 = new JButton("Add new customer");
		btnNewButton_9.setBackground(new Color(15, 240, 172));
		btnNewButton_9.setForeground(new Color(0, 0, 0));
		panel_35.add(btnNewButton_9);

		btnNewButton_16 = new JButton("Update customer");
		btnNewButton_16.setBackground(new Color(0, 128, 255));
		panel_35.add(btnNewButton_16);

		btnNewButton_17 = new JButton("Delete customer");
		btnNewButton_17.setBackground(new Color(255, 0, 0));
		panel_35.add(btnNewButton_17);

		panel_37 = new JPanel();
		panel_35.add(panel_37);
		panel_37.setLayout(new BoxLayout(panel_37, BoxLayout.X_AXIS));
		panel_37.setBorder(new EmptyBorder(0, 200, 0, 200));

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
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		panel_38.setBorder(new EmptyBorder(10, 0, 10, 0));

		btnNewButton_12 = new JButton("Add new employee");
		btnNewButton_12.setBackground(new Color(15, 240, 172));
		panel_38.add(btnNewButton_12);

		btnNewButton_18 = new JButton("Update employee");
		btnNewButton_18.setBackground(new Color(0, 128, 255));
		panel_38.add(btnNewButton_18);

		btnNewButton_19 = new JButton("Delete employee");
		btnNewButton_19.setBackground(new Color(255, 0, 0));
		panel_38.add(btnNewButton_19);

		panel_40 = new JPanel();
		panel_38.add(panel_40);
		panel_40.setLayout(new BoxLayout(panel_40, BoxLayout.X_AXIS));
		panel_40.setBorder(new EmptyBorder(0, 200, 0, 200));

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
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		roleControlPanel.add(lblNewLabel_19, BorderLayout.NORTH);
		lblNewLabel_19.setBorder(new EmptyBorder(10, 0, 10, 0));

		scrollPane_7 = new JScrollPane();
		roleControlPanel.add(scrollPane_7, BorderLayout.CENTER);

		table = new JTable();
		scrollPane_7.setViewportView(table);

		loadDataToTable();

		// Hiển thị các thành phần tùy vào role
		if ("1".equals(role) || "2".equals(role)) {
			// Admin Dashboard
//			var adminLabel = new JLabel("Welcome, Admin! Here are your management tools.");
//			adminLabel.setFont(new Font("Arial", Font.BOLD, 18));
//			contentPanel.add(adminLabel, BorderLayout.CENTER);
			pharmacyCounterPanel.setVisible(true);

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
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				// Sửa đường dẫn ở đây
				var is = Main.class.getResourceAsStream("/utils/style.css"); // Đường dẫn đến file CSS

				UIManager.put("Nimbus.Overrides", is);
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

	protected void btnMedicineManagementActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "medicineManagementPanel");
	}

	protected void btnRoleControlActionPerformed(ActionEvent e) {
		cardLayout.show(contentContainer, "roleControlPanel");
	}

	private void loadDataToTable() {
		// Tạo model cho bảng
		var model = new DefaultTableModel() {

			@Override
			public Class<?> getColumnClass(int column) {

				return switch (column) {
				case 0 -> Integer.class; // cột ID
				case 1 -> String.class; // cột Tên thuốc
				case 2 -> Integer.class; // cột Loại
				case 3 -> Integer.class; // cột Giá (hoặc Double.class, BigDecimal.class)
				case 4 -> Integer.class; // cột Số lượng
				case 5 -> LocalDate.class; // cột Ngày sản xuất
				case 6 -> LocalDate.class; // cột Ngày hết hạn
				default -> Object.class; // Trường hợp mặc định (nếu có)

				};
			}

		};

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
		table_Counter.setModel(model);
		table_Counter.getColumnModel().getColumn(1).setPreferredWidth(200); // columnIndex = 1 là cột "Tên thuốc"
		table_Counter.setRowHeight(40); // Ví dụ: tăng rowHeight lên 40 pixel
		table_Counter.getColumn("Tên thuốc").setCellRenderer(new ButtonRenderer());

	}

	protected void table_CounterMouseClicked(MouseEvent e) {
		var row = table_Counter.rowAtPoint(e.getPoint());
		var col = table_Counter.columnAtPoint(e.getPoint());

		if (col == 1 && e.getClickCount() == 1) { // Click vào cột "Tên thuốc"
			var medicineName = (String) table_Counter.getValueAt(row, col);

			// Lấy thông tin thuốc từ database
			var medicine = new MedicinesDao().getMedicineByName(medicineName); // Khởi tạo
																				// MedicinesDao

			if (medicine != null) {
				// Hiển thị hình ảnh (cần xử lý chuyển đổi từ byte[] sang ImageIcon)
				try { // Thêm try-catch để bắt lỗi khi chuyển đổi hình ảnh
					var imageIcon = new ImageIcon(medicine.getPicture());
					btnNewButton_6.setIcon(imageIcon);
				} catch (Exception ex) {
					System.err.println("Lỗi khi hiển thị hình ảnh: " + ex.getMessage());
					// Xử lý lỗi, ví dụ: hiển thị hình ảnh mặc định
				}

				// Hiển thị thông tin thuốc lên panel_CounterInfo
				medicineId.setText(String.valueOf(medicine.getId()));
				medicineNameInfo.setText(medicine.getMedicine_name());
				unitMeasure.setText("Đơn vị tính"); // Thay bằng đơn vị tính từ medicine
				price.setText(String.valueOf(medicine.getPrice()));
				// ... Hiển thị các thông tin khác ...
			}
		}

	}
}