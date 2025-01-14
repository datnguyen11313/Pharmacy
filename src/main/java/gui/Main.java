package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import dao.CategoriesDao;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.InvoiceDao;
import dao.MedicinesDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.StatisticsDao;
import entity.BestSellingProductsStatistics;
import entity.CustomerEntity;
import entity.EmployeeEntity;
import entity.InventoryStatistics;
import entity.InvoiceEntity;
import entity.MedicinesEntity;
import entity.OrderDetailEntity;
import entity.OrderEntity;
import entity.RevenueStatistics;
import gui.CustomerGUI.AddCustomerFrame;
import gui.CustomerGUI.UpdateCustomerFrame;
import gui.EmployeeGUI.AddNewEmployeeFrame;
import gui.EmployeeGUI.UpdateEmployeeFrame;
import utils.ButtonRenderer;
import utils.UIHelper;

public class Main extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
	private JPanel panel_Cart;
	private JPanel panel_Invoice;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane_Cart;
	private JTable table_Cart;
	private JLabel lblNewLabel_7;
	private JPanel panel_24;
	private JScrollPane scrollPane_Counter;
	private JTable table_Counter;
	private JLabel lblNewLabel_8;
	private JPanel panel_25;
	private JComboBox comboBox_Categories;
	private JTextField txtSearch;
	private JButton btnSearch;
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
	private JTextField txtAmountPaid;
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
	private JButton btnDeleteCart;
	private JButton btnMedicineManagement;
	private JButton btnProvider;
	private JButton btnInvoiceManagement;
	private JButton btnCustomer;
	private JButton btnStatistics;
	private JButton btnEmployee;
	private JPanel headerStatisticsPanel;
	private JPanel panel_17;
	private JPanel revenueStatisticsPanel;
	private JPanel inventoryStatisticsPanel;
	private JPanel bestSellingProductsPanel;
	private JButton btnRevenueStatistics;
	private JButton btnInventoryStatistics;
	private JButton btnBestSellingProductsStatistics;
	private CardLayout statisticsCardLayout; // Cho panel_17
	private JScrollPane scrollPane_5;
	private JTable table_5;
	private JPanel panel_28;
	private JPanel panel_29;
	private JDateChooser dateChooser_2;
	private JDateChooser dateChooser_3;
	private JPanel panel_30;
	private JPanel panel_41;
	private JLabel lblNewLabel_23;
	private JPanel panel_42;
	private JDateChooser dateChooser_4;
	private JDateChooser dateChooser_5;
	private JScrollPane scrollPane_8;
	private JTable table_6;
	private JPanel panel_43;
	private JPanel panel_44;
	private JLabel lblNewLabel_25;
	private JPanel panel_45;
	private JDateChooser dateChooser_6;
	private JDateChooser dateChooser_7;
	private JScrollPane scrollPane_9;
	private JTable table_7;
	private JPanel panel_46;
	private JButton btnNewButton_15;
	private JButton btnNewButton_20;
	private JButton btnNewButton_21;
	private ChartPanel chartPanel;
	private ChartPanel chartPanel_1;
	private ChartPanel chartPanel_2;
	private JButton btnRoleControl;
	private JLabel lblRole;
	private JLabel lblUserId;
	private JLabel lblNewLabel_19;
	private JScrollPane scrollPane_7;
	private JPanel panel;
	private JLabel lblNewLabel_21;
	private JTextField txt_AmountInfo;
	private JButton btnAddtoCart;

	private List<MedicinesEntity> cartItems = new ArrayList<>(); // Danh sách thuốc trong giỏ hàng
	private DefaultTableModel cartTableModel; // Model cho bảng Cart
	private DefaultTableModel EmployeeTableModel;
	private DefaultTableModel CustomerTableModel;
	private OrderDao orderDao;
	private InvoiceDao invoiceDao;
	private OrderDetailDao orderDetailDao;

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

		btnNewButton_6 = new JButton();
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\datng\\git\\Pharmacy\\images\\study-icon.png"));
		btnNewButton_6.setVisible(false);
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

		panel = new JPanel();
		panel_CounterInfoDetail.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_21 = new JLabel("Nhập Số Lượng :");
		panel.add(lblNewLabel_21);

		txt_AmountInfo = new JTextField();
		txt_AmountInfo.setColumns(10);
		panel.add(txt_AmountInfo);

		btnAddtoCart = new JButton("Add to Cart");
		btnAddtoCart.setIcon(new ImageIcon("images\\arrow-right-direction-green-icon.png"));
		btnAddtoCart.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAddtoCart.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_CounterInfoDetail.add(btnAddtoCart);

		panel_21 = new JPanel();
		counterHeader.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new BorderLayout(0, 0));

		panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_21.add(panel_24, BorderLayout.NORTH);

		panel_26 = new JPanel();
		panel_24.add(panel_26);

		comboBox_Categories = new JComboBox();
		panel_26.add(comboBox_Categories);
		comboBox_Categories.setModel(
				new DefaultComboBoxModel(new String[] { "All types", "Pain relief", "Antipyretic", "Vitamins" }));

		txtSearch = new JTextField();
		txtSearch.addActionListener(e -> {
			var searchText = txtSearch.getText().trim();
			filterMedicinesBySearch(searchText);
		});
		panel_26.add(txtSearch);

		txtSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(e -> {
			var searchText = txtSearch.getText().trim();
			filterMedicinesBySearch(searchText);
		});
		panel_26.add(btnSearch);

		panel_27 = new JPanel();
		panel_24.add(panel_27);

		txtAmount = new JTextField();
		txtAmount.addActionListener(e -> {

		});
		panel_27.add(txtAmount);
		txtAmount.setText("Amount");
		txtAmount.setColumns(10);

		btnNewButton_5 = new JButton("Add");
		panel_27.add(btnNewButton_5);

		scrollPane_Counter = new JScrollPane();
		scrollPane_Counter.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_21.add(scrollPane_Counter, BorderLayout.CENTER);

		table_Counter = new JTable();
		table_Counter.setBorder(null);
		table_Counter.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

		panel_Cart = new JPanel();
		panel_19.add(panel_Cart, BorderLayout.NORTH);
		panel_Cart.setLayout(new BorderLayout(0, 0));

		lblNewLabel_6 = new JLabel("Cart");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Cart.add(lblNewLabel_6, BorderLayout.NORTH);

		scrollPane_Cart = new JScrollPane();
		panel_Cart.add(scrollPane_Cart, BorderLayout.CENTER);

		table_Cart = new JTable();
		scrollPane_Cart.setViewportView(table_Cart);

		EmployeeTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa ô
			}
		};

		CustomerTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa ô
			}
		};

		// Khởi tạo model cho bảng Cart
		cartTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa ô
			}
		};
		cartTableModel.addColumn("Tên thuốc");
		cartTableModel.addColumn("Số lượng");
		cartTableModel.addColumn("Đơn giá");
		cartTableModel.addColumn("Thành tiền");
		table_Cart.setModel(cartTableModel);

		btnAddtoCart.addActionListener(e -> {
			try {
				// 1. Lấy thông tin thuốc
				var medicineName = medicineNameInfo.getText();
				// Kiểm tra xem txt_AmountInfo có chứa giá trị hợp lệ không
				var amountText = txt_AmountInfo.getText().trim();
				if (amountText.isEmpty() || !amountText.matches("\\d+")) {
					JOptionPane.showMessageDialog(Main.this, "Vui lòng nhập số lượng hợp lệ", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				var amount = Integer.parseInt(amountText);

				var priceValue = new BigDecimal(price.getText());

				// 3. Tạo MedicinesEntity
				var cartItem = new MedicinesEntity();
				cartItem.setMedicine_name(medicineName);
				cartItem.setStock(amount);
				cartItem.setPrice(priceValue);

				// 4. Thêm vào cartItems
				cartItems.add(cartItem);

				// 5. Cập nhật bảng Cart
				updateCartTable();

				// 6. Xóa trường nhập liệu
				txt_AmountInfo.setText("");

				// 7. Tạo mã hóa đơn (OrderEntity)
				var orderId = generateOrderId(); // Tạo mã order
				textField_10.setText(orderId); // Hiển thị mã hóa đơn (order)

				// 8. Tạo OrderEntity
				var order = new OrderEntity();
				order.setId(Integer.parseInt(orderId));
				order.setOrder_date(LocalDate.now());
				order.setStatus(false); // Gán trạng thái ban đầu
			} catch (NumberFormatException ex) {

			}

		});

		btnDeleteCart = new JButton("Delete");
		btnDeleteCart.setBackground(new Color(255, 0, 0));
		panel_Cart.add(btnDeleteCart, BorderLayout.SOUTH);

		panel_Invoice = new JPanel();
		panel_19.add(panel_Invoice, BorderLayout.CENTER);
		panel_Invoice.setLayout(new BorderLayout(0, 0));

		lblNewLabel_8 = new JLabel("Invoice");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Invoice.add(lblNewLabel_8, BorderLayout.NORTH);

		panel_25 = new JPanel();
		panel_25.setLayout(new GridLayout(0, 2, 0, 0));
		panel_Invoice.add(panel_25, BorderLayout.CENTER);

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

		lblNewLabel_17 = new JLabel("Note");
		panel_25.add(lblNewLabel_17);
		textField_13 = new JTextField();
		panel_25.add(textField_13);
		textField_13.setColumns(10);

		lblNewLabel_18 = new JLabel("Tiền Khách Đưa");
		panel_25.add(lblNewLabel_18);
		txtAmountPaid = new JTextField();
		panel_25.add(txtAmountPaid);
		txtAmountPaid.setColumns(10);

		lblNewLabel_16 = new JLabel("Tổng Tiền");
		panel_25.add(lblNewLabel_16);
		textField_13 = new JTextField();
		panel_25.add(textField_13);
		textField_13.setColumns(10);

		btnNewButton_7 = new JButton("HỦY BỎ");
		btnNewButton_7.setBackground(new Color(255, 0, 0));
		panel_25.add(btnNewButton_7);

		btnNewButton_8 = new JButton("IN HÓA ĐƠN");
		btnNewButton_8.addActionListener(e -> btnCreateInvoiceActionPerformed());
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
		btnNewButton_9.addActionListener(this::btnNewButton_9ActionPerformed);
		btnNewButton_9.setBackground(new Color(15, 240, 172));
		btnNewButton_9.setForeground(new Color(0, 0, 0));
		panel_35.add(btnNewButton_9);

		btnNewButton_16 = new JButton("Update customer");
		btnNewButton_16.addActionListener(this::btnNewButton_16ActionPerformed);
		btnNewButton_16.setBackground(new Color(0, 128, 255));
		panel_35.add(btnNewButton_16);

		btnNewButton_17 = new JButton("Delete customer");
		btnNewButton_17.addActionListener(this::btnNewButton_17ActionPerformed);
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
		btnNewButton_11.addActionListener(this::btnNewButton_11ActionPerformed);
		panel_37.add(btnNewButton_11);

		btnNewButton_10 = new JButton("Refresh");
		btnNewButton_10.addActionListener(this::btnNewButton_10ActionPerformed);
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

		statisticsPanel.setLayout(new BorderLayout(0, 0));
		headerStatisticsPanel = new JPanel();
		statisticsPanel.add(headerStatisticsPanel, BorderLayout.NORTH);
		headerStatisticsPanel.setLayout(new BoxLayout(headerStatisticsPanel, BoxLayout.X_AXIS));
		btnRevenueStatistics = new JButton("Revenue");
		btnRevenueStatistics.addActionListener(this::btnRevenueStatisticsActionPerformed);
		headerStatisticsPanel.add(btnRevenueStatistics);
		btnInventoryStatistics = new JButton("Inventory");
		btnInventoryStatistics.addActionListener(this::btnInventoryStatisticsActionPerformed);
		headerStatisticsPanel.add(btnInventoryStatistics);
		btnBestSellingProductsStatistics = new JButton("Best Selling Products");
		btnBestSellingProductsStatistics.addActionListener(this::btnBestSellingProductsStatisticsActionPerformed);
		headerStatisticsPanel.add(btnBestSellingProductsStatistics);
		panel_17 = new JPanel();
		statisticsPanel.add(panel_17);
		statisticsCardLayout = new CardLayout(0, 0);
		panel_17.setLayout(statisticsCardLayout);
		revenueStatisticsPanel = new JPanel();
		revenueStatisticsPanel.setBackground(new Color(255, 255, 128));
		panel_17.add(revenueStatisticsPanel, "revenueStatisticsPanel");
		revenueStatisticsPanel.setLayout(new BorderLayout(0, 0));
		scrollPane_5 = new JScrollPane();
		revenueStatisticsPanel.add(scrollPane_5, BorderLayout.CENTER);
		table_5 = new JTable();
		table_5.setAutoCreateRowSorter(true);
		scrollPane_5.setViewportView(table_5);
		panel_28 = new JPanel();
		revenueStatisticsPanel.add(panel_28, BorderLayout.NORTH);
		panel_28.setLayout(new BorderLayout(0, 0));
		lblNewLabel_20 = new JLabel("Filter theo ngày (From - To)");
		panel_28.add(lblNewLabel_20, BorderLayout.NORTH);
		panel_29 = new JPanel();
		panel_28.add(panel_29, BorderLayout.CENTER);
		panel_29.setLayout(new BoxLayout(panel_29, BoxLayout.X_AXIS));
		dateChooser_2 = new JDateChooser();
		dateChooser_2
				.setDate(Date.from(LocalDate.now().minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		panel_29.add(dateChooser_2);
		dateChooser_3 = new JDateChooser();
		dateChooser_3.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		panel_29.add(dateChooser_3);
		btnNewButton_15 = new JButton("Thống kê");
		btnNewButton_15.addActionListener(this::btnNewButton_15ActionPerformed);
		panel_29.add(btnNewButton_15);
		panel_30 = new JPanel();
		revenueStatisticsPanel.add(panel_30, BorderLayout.EAST);
		chartPanel = new ChartPanel((JFreeChart) null);
		panel_30.add(chartPanel);
		inventoryStatisticsPanel = new JPanel();
		inventoryStatisticsPanel.setBackground(new Color(128, 255, 128));
		panel_17.add(inventoryStatisticsPanel, "inventoryStatisticsPanel");
		inventoryStatisticsPanel.setLayout(new BorderLayout(0, 0));
		panel_41 = new JPanel();
		inventoryStatisticsPanel.add(panel_41, BorderLayout.NORTH);
		panel_41.setLayout(new BorderLayout(0, 0));
		lblNewLabel_23 = new JLabel("Theo hạn sử dụng (From - To)");
		panel_41.add(lblNewLabel_23, BorderLayout.NORTH);
		panel_42 = new JPanel();
		panel_41.add(panel_42, BorderLayout.CENTER);
		panel_42.setLayout(new BoxLayout(panel_42, BoxLayout.X_AXIS));
		dateChooser_4 = new JDateChooser();
		dateChooser_4
				.setDate(Date.from(LocalDate.now().minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		panel_42.add(dateChooser_4);
		dateChooser_5 = new JDateChooser();
		dateChooser_5.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		panel_42.add(dateChooser_5);
		btnNewButton_20 = new JButton("Thống kê");
		btnNewButton_20.addActionListener(this::btnNewButton_20ActionPerformed);
		panel_42.add(btnNewButton_20);
		scrollPane_8 = new JScrollPane();
		inventoryStatisticsPanel.add(scrollPane_8, BorderLayout.CENTER);
		table_6 = new JTable();
		table_6.setAutoCreateRowSorter(true);
		scrollPane_8.setViewportView(table_6);
		panel_43 = new JPanel();
		inventoryStatisticsPanel.add(panel_43, BorderLayout.EAST);
		chartPanel_1 = new ChartPanel((JFreeChart) null);
		panel_43.add(chartPanel_1);
		bestSellingProductsPanel = new JPanel();
		bestSellingProductsPanel.setBackground(new Color(128, 255, 255));
		panel_17.add(bestSellingProductsPanel, "bestSellingProductsPanel");
		bestSellingProductsPanel.setLayout(new BorderLayout(0, 0));
		panel_44 = new JPanel();
		bestSellingProductsPanel.add(panel_44, BorderLayout.NORTH);
		panel_44.setLayout(new BorderLayout(0, 0));
		lblNewLabel_25 = new JLabel("Theo ngày (From - To)");
		panel_44.add(lblNewLabel_25, BorderLayout.NORTH);
		panel_45 = new JPanel();
		panel_44.add(panel_45, BorderLayout.CENTER);
		panel_45.setLayout(new BoxLayout(panel_45, BoxLayout.X_AXIS));
		dateChooser_6 = new JDateChooser();
		dateChooser_6
				.setDate(Date.from(LocalDate.now().minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		panel_45.add(dateChooser_6);
		dateChooser_7 = new JDateChooser();
		dateChooser_7.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		panel_45.add(dateChooser_7);
		btnNewButton_21 = new JButton("Thống kê");
		btnNewButton_21.addActionListener(this::btnNewButton_21ActionPerformed);
		panel_45.add(btnNewButton_21);
		scrollPane_9 = new JScrollPane();
		bestSellingProductsPanel.add(scrollPane_9, BorderLayout.CENTER);
		table_7 = new JTable();
		table_7.setAutoCreateRowSorter(true);
		scrollPane_9.setViewportView(table_7);
		panel_46 = new JPanel();
		bestSellingProductsPanel.add(panel_46, BorderLayout.EAST);
		chartPanel_2 = new ChartPanel((JFreeChart) null);
		panel_46.add(chartPanel_2);

		employeeManagementPanel = new JPanel();
		employeeManagementPanel.setBackground(new Color(255, 128, 192));
		contentContainer.add(employeeManagementPanel, "employeeManagementPanel");
		employeeManagementPanel.setLayout(new BorderLayout(0, 0));

		panel_38 = new JPanel();
		employeeManagementPanel.add(panel_38, BorderLayout.NORTH);
		panel_38.setLayout(new BoxLayout(panel_38, BoxLayout.X_AXIS));
		panel_38.setBorder(new EmptyBorder(10, 0, 10, 0));

		btnNewButton_12 = new JButton("Add new employee");
		btnNewButton_12.addActionListener(this::btnNewButton_12ActionPerformed);
		btnNewButton_12.setBackground(new Color(15, 240, 172));
		panel_38.add(btnNewButton_12);

		btnNewButton_18 = new JButton("Update employee");
		btnNewButton_18.addActionListener(this::btnNewButton_18ActionPerformed);
		btnNewButton_18.setBackground(new Color(0, 128, 255));
		panel_38.add(btnNewButton_18);

		btnNewButton_19 = new JButton("Delete employee");
		btnNewButton_19.addActionListener(this::btnNewButton_19ActionPerformed);
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
		btnNewButton_14.addActionListener(this::btnNewButton_14ActionPerformed);
		panel_40.add(btnNewButton_14);

		btnNewButton_13 = new JButton("Refresh");
		btnNewButton_13.addActionListener(this::btnNewButton_13ActionPerformed);
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
		// call function
		loadDataToTable();
		loadCategoriesToComboBox();
		loadAllEmployee();
		loadAllCustomer();

		comboBox_Categories.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				var selectedCategory = (String) comboBox_Categories.getSelectedItem();
				filterMedicinesByCategory(selectedCategory);
			}
		});

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
					case 0 -> String.class; // cột Tên thuốc
					case 1 -> String.class; // cột Tên loại
					case 2 -> BigDecimal.class; // cột Giá
					case 3 -> Integer.class; // cột Số lượng
					case 4 -> String.class; // cột Đơn vị
					case 5 -> LocalDate.class; // cột Ngày hết hạn
					default -> Object.class; // Trường hợp mặc định

				};
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa bất kỳ ô nào
			}

		};

		model.addColumn("Tên thuốc");
		model.addColumn("Loại");
		model.addColumn("Giá");
		model.addColumn("Số lượng");
		model.addColumn("Đơn vị");
		model.addColumn("Ngày hết hạn");

		model.setRowCount(0);

		// Khởi tạo DAO và lấy dữ liệu
		var dao = new MedicinesDao();
		dao.select().forEach(medicine -> {
			model.addRow(new Object[] {

					medicine.getMedicine_name(), medicine.getCategory().getCaterogy_name(), medicine.getPrice(),
					medicine.getStock(), medicine.getUnit(),

					medicine.getExpiry_date() });
		});

		// Gắn model vào bảng
		table_medicines.setModel(model);
		table_Counter.setModel(model);
		table_Counter.getColumnModel().getColumn(1).setPreferredWidth(200); // columnIndex = 1 là cột "Tên thuốc"
		table_Counter.setRowHeight(40); // Ví dụ: tăng rowHeight lên 40 pixel
		table_Counter.getColumn("Tên thuốc").setCellRenderer(new ButtonRenderer());

		model.fireTableDataChanged();

	}

	protected void table_CounterMouseClicked(MouseEvent e) {
		var row = table_Counter.rowAtPoint(e.getPoint());
		var col = table_Counter.columnAtPoint(e.getPoint());

		if (col >= 0 && col <= 5 && e.getClickCount() == 1) {
			var medicineName = (String) table_Counter.getValueAt(row, 0);

			// Lấy thông tin thuốc từ database
			var medicine = new MedicinesDao().getMedicineByName(medicineName); // Khởi tạo
																				// MedicinesDao

			if (medicine != null) {
				// Hiển thị hình ảnh (cần xử lý chuyển đổi từ byte[] sang ImageIcon)
				try { // Thêm try-catch để bắt lỗi khi chuyển đổi hình ảnh
					var imageIcon = new ImageIcon(medicine.getPicture());
					// Thay đổi kích thước ảnh
					var image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
					var resizedIcon = new ImageIcon(image);
					btnNewButton_6.setIcon(resizedIcon);
				} catch (Exception ex) {
					System.err.println("Lỗi khi hiển thị hình ảnh: " + ex.getMessage());
					// Xử lý lỗi, ví dụ: hiển thị hình ảnh mặc định
				}

				// Hiển thị thông tin thuốc lên panel_CounterInfo
				medicineId.setText(String.valueOf(medicine.getId()));
				medicineNameInfo.setText(medicine.getMedicine_name());
				var df = new DecimalFormat("#,###.##");
				unitMeasure.setText(medicine.getUnit()); // Thay bằng đơn vị tính từ medicine
				price.setText(medicine.getPrice().toString());
				btnNewButton_6.setVisible(true);

			}
		}
	}

	protected void btnRevenueStatisticsActionPerformed(ActionEvent e) {
		statisticsCardLayout.show(panel_17, "revenueStatisticsPanel");
	}

	protected void btnInventoryStatisticsActionPerformed(ActionEvent e) {
		statisticsCardLayout.show(panel_17, "inventoryStatisticsPanel");
	}

	protected void btnBestSellingProductsStatisticsActionPerformed(ActionEvent e) {
		statisticsCardLayout.show(panel_17, "bestSellingProductsPanel");
	}

	protected void btnNewButton_15ActionPerformed(ActionEvent e) {
		if (dateChooser_2.getDate() == null || dateChooser_3.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu và kết thúc", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		var fromdate = dateChooser_2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		var todate = dateChooser_3.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		var doanhThu = new StatisticsDao().revenueStatistics(fromdate, todate);
		var model = new DefaultTableModel();
		model.addColumn("Ngày");
		model.addColumn("Tổng doanh thu");
		model.addColumn("Số lượng đơn hàng");
		for (RevenueStatistics dt : doanhThu) {
			model.addRow(new Object[] { dt.getOrder_date(), dt.getTotalRevenue(), dt.getTotalOrder() });
		}
		table_5.setModel(model);
		// Tạo biểu đồ
		var revenueChart = createRevenueChart(doanhThu);
		// Thêm biểu đồ vào panel_30
		var chartPanel = new ChartPanel(revenueChart);
		panel_30.removeAll(); // Xóa nội dung cũ (nếu có)
		panel_30.add(chartPanel, BorderLayout.CENTER);
		panel_30.validate(); // Cập nhật lại panel
		panel_30.repaint();
	}

	protected void btnNewButton_20ActionPerformed(ActionEvent e) {
		if (dateChooser_4.getDate() == null || dateChooser_5.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu và kết thúc", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		var fromDate = dateChooser_4.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		var toDate = dateChooser_5.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		var inventory = new StatisticsDao().inventoryStatistics(fromDate, toDate);
		// Tạo model cho bảng
		var model = new DefaultTableModel();
		model.addColumn("Mã thuốc");
		model.addColumn("Tên thuốc");
		model.addColumn("Danh mục");
		model.addColumn("Số lượng tồn kho");
		model.addColumn("Ngày hết hạn");
		// Thêm dữ liệu vào model
		for (InventoryStatistics item : inventory) {
			model.addRow(new Object[] { item.getMedicineId(), item.getMedicineName(), item.getMedicineCategory(),
					item.getInventoryAmount(), item.getExpiredDate() });
		}
		// Hiển thị dữ liệu trên table_6
		table_6.setModel(model);
		// Tạo biểu đồ
		var inventoryChart = createInventoryChart(inventory);
		// Thêm biểu đồ vào panel_43
		var chartPanel = new ChartPanel(inventoryChart);
		panel_43.removeAll(); // Xóa nội dung cũ (nếu có)
		panel_43.add(chartPanel, BorderLayout.CENTER);
		panel_43.validate(); // Cập nhật lại panel
		panel_43.repaint();
	}

	protected void btnNewButton_21ActionPerformed(ActionEvent e) {
		if (dateChooser_6.getDate() == null || dateChooser_7.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu và kết thúc", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		var fromDate = dateChooser_6.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		var toDate = dateChooser_7.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		var bestSelling = new StatisticsDao().bestSellingProductsStatistics(fromDate, toDate);
		// Tạo model cho bảng
		var model = new DefaultTableModel();
		model.addColumn("Mã thuốc");
		model.addColumn("Tên thuốc");
		model.addColumn("Số lượng đã bán");
		model.addColumn("Doanh thu");
		// Thêm dữ liệu vào model
		for (BestSellingProductsStatistics item : bestSelling) {
			model.addRow(new Object[] { item.getMedicineId(), item.getMedicineName(), item.getTotalSellingAmount(),
					item.getTotalRevenue() });
		}
		// Hiển thị dữ liệu trên table_7
		table_7.setModel(model);
		// Tạo biểu đồ
		var bestSellingChart = createBestSellingChart(bestSelling);
		// Thêm biểu đồ vào panel_46
		var chartPanel = new ChartPanel(bestSellingChart);
		panel_46.removeAll(); // Xóa nội dung cũ (nếu có)
		panel_46.add(chartPanel, BorderLayout.CENTER);
		panel_46.validate(); // Cập nhật lại panel
		panel_46.repaint();
	}

	// vẽ biểu đồ cho RevenueStatistics
	private JFreeChart createRevenueChart(List<RevenueStatistics> doanhThu) {
		// tạo dataset
		var dataset = new DefaultCategoryDataset();
		for (RevenueStatistics dt : doanhThu) {
			dataset.addValue(dt.getTotalRevenue(), "Doanh thu", dt.getOrder_date().toString());
		}
		// tạo biểu đồ cột
		var barChart = ChartFactory.createBarChart("Biểu đồ doanh thu", "Ngày", "Doanh thu", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		// tùy chỉnh biểu đồ
		var plot = barChart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.black);
		return barChart;
	}

	// vẽ biểu đồ cho InventoryStatistics
	private JFreeChart createInventoryChart(List<InventoryStatistics> inventory) {
		// tạo dataset
		var dataset = new DefaultCategoryDataset();
		for (InventoryStatistics item : inventory) {
			// Chuyển đổi java.sql.Date sang java.time.LocalDate
			var expiredDate = item.getExpiredDate().toLocalDate();
			dataset.addValue(item.getInventoryAmount(), "Số lượng", expiredDate.toString());
		}
		// tạo biểu đồ cột
		var barChart = ChartFactory.createBarChart("Biểu đồ tồn kho", "Ngày hết hạn", "Số lượng", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		// tùy chỉnh biểu đồ
		var plot = barChart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.black);
		return barChart;
	}

	// vẽ biểu đồ cho BestSellingProductsStatistics
	private JFreeChart createBestSellingChart(List<BestSellingProductsStatistics> bestSelling) {
		// tạo dataset
		var dataset = new DefaultCategoryDataset();
		for (BestSellingProductsStatistics item : bestSelling) {
			dataset.addValue(item.getTotalSellingAmount(), "Số lượng", item.getMedicineName());
		}
		// tạo biểu đồ cột
		var barChart = ChartFactory.createBarChart("Biểu đồ sản phẩm bán chạy", "Tên thuốc", "Số lượng", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		// tùy chỉnh biểu đồ
		var plot = barChart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.black);
		return barChart;
	}

	private void loadCategoriesToComboBox() {
		var categoriesDao = new CategoriesDao(); // Khởi tạo DAO
		var categories = categoriesDao.getAllCategories(); // Lấy danh sách danh mục

		comboBox_Categories.removeAllItems(); // Xóa các item cũ
		comboBox_Categories.addItem("All"); // Thêm mục "All" để hiển thị tất cả thuốc

		for (String category : categories) {
			comboBox_Categories.addItem(category); // Thêm danh mục vào ComboBox
		}
	}

	private void filterMedicinesByCategory(String category) {
		var model = (DefaultTableModel) table_Counter.getModel();
		model.setRowCount(0); // Xóa dữ liệu hiện tại

		var medicinesDao = new MedicinesDao();
		List<MedicinesEntity> filteredMedicines;

		if (category.equals("All")) {
			filteredMedicines = medicinesDao.select(); // Lấy tất cả thuốc
		} else {
			filteredMedicines = medicinesDao.getMedicinesByCategory(category); // Lọc theo danh mục
		}

		// Thêm dữ liệu vào model
		for (var medicine : filteredMedicines) {
			model.addRow(new Object[] { medicine.getMedicine_name(), medicine.getCategory().getCaterogy_name(),
					medicine.getPrice(), medicine.getStock(), medicine.getUnit(), medicine.getExpiry_date() });
		}

		model.fireTableDataChanged(); // Cập nhật table
	}

	private void filterMedicinesBySearch(String searchText) {
		var model = (DefaultTableModel) table_Counter.getModel();
		model.setRowCount(0); // Xóa dữ liệu hiện tại

		var medicinesDao = new MedicinesDao();
		var filteredMedicines = medicinesDao.searchMedicines(searchText); // Tìm kiếm trong CSDL

		// Thêm dữ liệu vào model
		for (var medicine : filteredMedicines) {
			model.addRow(new Object[] { medicine.getMedicine_name(), medicine.getCategory().getCaterogy_name(),
					medicine.getPrice(), medicine.getStock(), medicine.getUnit(), medicine.getExpiry_date() });
		}

		model.fireTableDataChanged();
	}

	private void updateCartTable() {
		cartTableModel.setRowCount(0);

		for (MedicinesEntity item : cartItems) {
			var totalPrice = item.getPrice().multiply(BigDecimal.valueOf(item.getStock()));
			cartTableModel
					.addRow(new Object[] { item.getMedicine_name(), item.getStock(), item.getPrice(), totalPrice });
		}

		cartTableModel.fireTableDataChanged();

		// Tính toán tổng tiền
		var totalAmount = BigDecimal.ZERO;
		for (MedicinesEntity item : cartItems) {
			totalAmount = totalAmount.add(item.getPrice().multiply(BigDecimal.valueOf(item.getStock())));
		}

		// Cập nhật panel_Invoice
		textField_13.setText(totalAmount.toString()); // Hiển thị tổng tiền
		panel_Invoice.setVisible(true);
	}

	private String generateOrderId() {
		orderDao = new OrderDao();
		var currentDate = LocalDate.now();
		var formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		var datePart = currentDate.format(formatter);

		// Lấy số thứ tự lớn nhất trong ngày từ database
		var lastOrderNumber = orderDao.getLastOrderNumberForDate(datePart); // Giả sử bạn có phương thức này

		// Tăng số thứ tự lên 1
		var newOrderNumber = lastOrderNumber + 1;

		// Định dạng mã order mới
		var df = new DecimalFormat("0000"); // Định dạng 4 chữ số
		var newOrderId = "OD" + datePart + df.format(newOrderNumber);

		return newOrderId;
	}

	private void loadEmployeeData(List<EmployeeEntity> employees) {
		var model = new DefaultTableModel() {
			// Không cho phép chỉnh sửa ô
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa ô
			}
		};

		// Thêm cột cho bảng
		model.addColumn("ID");
		model.addColumn("Full Name");
		model.addColumn("Phone Number");
		model.addColumn("Email");
		model.addColumn("Address");
		model.addColumn("Identity Card");
		model.addColumn("Role");
		model.addColumn("Salary");
		model.addColumn("Start Date");
		model.addColumn("Created At");
		model.addColumn("Updated At");
		model.addColumn("Picture");

		// Thêm dữ liệu vào bảng
		for (EmployeeEntity emp : employees) {
			model.addRow(new Object[] { emp.getId(), emp.getFullName(), emp.getPhoneNumber(), emp.getEmail(),
					emp.getAddress(), emp.getIdentityCard(), emp.getRoleID(), emp.getSalary(), emp.getStartDate(),
					emp.getCreatedAt(), emp.getUpdatedAt(), emp.getPicture() // Picture có thể là đường dẫn hoặc biểu
																				// diễn nào khác
			});
		}

		// Gắn model vào table
		table_4.setModel(model);
	}

	private void loadAllEmployee() {
		var employeeDAO = new EmployeeDAO();
		var employees = employeeDAO.getAllEmployees();
		loadEmployeeData(employees);
	}

	private void loadCustomerData(List<CustomerEntity> customers) {
		var model = new DefaultTableModel() {
			// Không cho phép chỉnh sửa ô
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa ô
			}
		};

		// Thêm các cột cho bảng dữ liệu
		model.addColumn("ID");
		model.addColumn("Full Name");
		model.addColumn("Phone Number");
		model.addColumn("Email");
		model.addColumn("Address");
		model.addColumn("Date Of Birth");
		model.addColumn("Customer Type");
		model.addColumn("Points");
		model.addColumn("Created At");
		model.addColumn("Updated At");
		model.addColumn("Picture");

		// Thêm dữ liệu vào bảng
		for (CustomerEntity customer : customers) {
			model.addRow(new Object[] { customer.getId(), customer.getFull_name(), customer.getPhone_number(),
					customer.getEmail(), customer.getAddress(), customer.getDateOfBirth(), customer.getCustomerType(),
					customer.getPoints(), customer.getCreatedAt(), customer.getUpdatedAt(), customer.getPicture() });
		}

		// Gắn model vào table
		table_1.setModel(model); // customerTable là tên của JTable chứa dữ liệu khách hàng
	}

	private void loadAllCustomer() {
		var customerDAO = new CustomerDAO(); // Tạo đối tượng CustomerDAO để lấy dữ liệu khách hàng
		var customers = customerDAO.getAllCustomers(); // Gọi phương thức lấy tất cả khách hàng
		loadCustomerData(customers); // Hiển thị dữ liệu
	}

	private void searchEmployeeData(String fullName) {
		var employeeDAO = new EmployeeDAO();
		List<EmployeeEntity> employees;

		// Kiểm tra giá trị tìm kiếm
		if (fullName == null || fullName.isEmpty()) {
			employees = employeeDAO.getAllEmployees(); // Lấy tất cả nếu không nhập
		} else {
			employees = employeeDAO.searchEmployeesByName(fullName); // Tìm kiếm theo tên
		}

		loadEmployeeData(employees);
	}

	private void searchCustomerData(String fullName) {
		var customerDAO = new CustomerDAO();
		List<CustomerEntity> customers;

		if (fullName == null || fullName.isEmpty()) {
			customers = customerDAO.getAllCustomers(); // Nếu không nhập, lấy toàn bộ
		} else {
			customers = customerDAO.searchCustomersByName(fullName); // Tìm kiếm theo tên
		}

		loadCustomerData(customers); // Hiển thị dữ liệu
	}

	private void deleteSelectedEmployee() {
		// Lấy dòng được chọn
		var selectedRow = table_4.getSelectedRow();

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Please select an employee to delete.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Xác nhận hành động xóa
		var confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?",
				"Confirm Delete", JOptionPane.YES_NO_OPTION);

		if (confirm != JOptionPane.YES_OPTION) {
			return; // Người dùng không muốn xóa
		}

		// Lấy ID nhân viên từ bảng
		var employeeId = Integer.parseInt(table_4.getValueAt(selectedRow, 0).toString());

		// Cập nhật isDelete = 0 trong cơ sở dữ liệu
		var employeeDAO = new EmployeeDAO();
		var isDeleted = employeeDAO.deleteEmployeeById(employeeId);

		if (isDeleted) {
			JOptionPane.showMessageDialog(null, "Employee deleted successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);

			// Cập nhật lại bảng
			loadAllEmployee(); // Refresh dữ liệu bảng
		} else {
			JOptionPane.showMessageDialog(null, "Failed to delete employee.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteSelectedCustomer() {
		// Lấy dòng được chọn
		var selectedRow = table_1.getSelectedRow();

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Please select a customer to delete.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Xác nhận hành động xóa
		var confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this customer?",
				"Confirm Delete", JOptionPane.YES_NO_OPTION);

		if (confirm != JOptionPane.YES_OPTION) {
			return; // Người dùng không muốn xóa
		}

		// Lấy ID khách hàng từ bảng
		var customerId = Integer.parseInt(table_1.getValueAt(selectedRow, 0).toString());

		// Cập nhật isDelete = 0 trong cơ sở dữ liệu (có thể thay isDelete bằng trường
		// xóa trong cơ sở dữ liệu của bạn)
		var customerDAO = new CustomerDAO();
		var isDeleted = customerDAO.deleteCustomerById(customerId);

		if (isDeleted) {
			JOptionPane.showMessageDialog(null, "Customer deleted successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);

			// Cập nhật lại bảng
			loadAllCustomer(); // Refresh dữ liệu bảng
		} else {
			JOptionPane.showMessageDialog(null, "Failed to delete customer.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void btnCreateInvoiceActionPerformed() {
		try {
			// 1. Lấy thông tin từ panel_Invoice
			var customerName = textField_12.getText();
			var customerPhone = textField_11.getText();
			var totalAmount = Integer.parseInt(textField_13.getText());
			var amountPaid = Integer.parseInt(txtAmountPaid.getText()); // Giả sử txtAmountPaid là JTextField mới
			var paymentStatus = true; // Hoặc false tùy thuộc vào trạng thái thanh toán
			var notes = textField_14.getText();

			// 2. Tạo InvoiceEntity
			var invoice = new InvoiceEntity();
			var order = new OrderEntity();
			invoice.setOrder_id(Integer.parseInt(textField_10.getText())); // Lấy order_id từ textField_10
			invoice.setCustomer_name(customerName);
			invoice.setCustomer_phone(customerPhone);
			invoice.setTotal_amount(totalAmount);
			invoice.setAmount_paid(amountPaid);
			invoice.setPayment_status(paymentStatus);
			order.setNotes(notes);
			invoice.setInvoice_date(LocalDate.now()); // Thêm ngày tạo hóa đơn

			// 3. Tạo danh sách OrderDetailEntity
			List<OrderDetailEntity> orderDetails = new ArrayList<>();
			for (MedicinesEntity cartItem : cartItems) {
				var orderDetail = new OrderDetailEntity();
				orderDetail.setOrder_id(invoice.getOrder_id());
				orderDetail.setMedicine_id(cartItem.getId());
				orderDetail.setQuantity(cartItem.getStock());
				orderDetail.setUnit_price(cartItem.getPrice());
				orderDetail.setTotal_price(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getStock())));
				orderDetails.add(orderDetail);
			}

			// 4. Lưu vào cơ sở dữ liệu (bước 2)
			orderDao.insertOrder(order); // Lưu OrderEntity
			invoiceDao.insertInvoice(invoice); // Lưu InvoiceEntity

			for (OrderDetailEntity orderDetail : orderDetails) {
				orderDetailDao.insertOrderDetail(orderDetail); // Lưu từng OrderDetailEntity
			}

		} catch (NumberFormatException ex) {
			// Xử lý lỗi chuyển đổi số
			JOptionPane.showMessageDialog(Main.this, "Lỗi chuyển đổi số", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Update Emp
	protected void btnNewButton_18ActionPerformed(ActionEvent e) {
		var selectedRow = table_4.getSelectedRow();
		if (selectedRow != -1) {
			var employeeId = Integer.parseInt(table_4.getValueAt(selectedRow, 0).toString());
			new UpdateEmployeeFrame(employeeId, table_4, selectedRow);
		} else {
			JOptionPane.showMessageDialog(null, "Please select an employee to update.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Refresh Emp
	protected void btnNewButton_13ActionPerformed(ActionEvent e) {
		loadAllEmployee();
	}

	// Add Emp
	protected void btnNewButton_12ActionPerformed(ActionEvent e) {
		new AddNewEmployeeFrame().setVisible(true);
	}

	// Delete Emp
	protected void btnNewButton_19ActionPerformed(ActionEvent e) {
		deleteSelectedEmployee();
	}

	// Add Cus
	protected void btnNewButton_9ActionPerformed(ActionEvent e) {
		new AddCustomerFrame().setVisible(true);
	}

	// Refresh Cus
	protected void btnNewButton_10ActionPerformed(ActionEvent e) {
		loadAllCustomer();
	}

	// Delete Cus
	protected void btnNewButton_17ActionPerformed(ActionEvent e) {
		deleteSelectedCustomer();
	}

	// Update Cus
	// Update Customer
	protected void btnNewButton_16ActionPerformed(ActionEvent e) {
		var selectedRow = table_1.getSelectedRow();
		if (selectedRow != -1) {
			var customerId = Integer.parseInt(table_1.getValueAt(selectedRow, 0).toString());
			new UpdateCustomerFrame(customerId, table_1, selectedRow);
		} else {
			JOptionPane.showMessageDialog(null, "Please select a customer to update.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void btnNewButton_14ActionPerformed(ActionEvent e) {
		var searchText = textField_15.getText().trim(); // Lấy giá trị từ textField
		searchEmployeeData(searchText);
	}

	protected void btnNewButton_11ActionPerformed(ActionEvent e) {
		var searchText = textField_14.getText().trim(); // Lấy giá trị từ textField
		searchCustomerData(searchText);
	}
}