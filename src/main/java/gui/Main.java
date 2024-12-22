package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPanel;
	private String role;
	private JPanel navigation;
	private JPanel userInfoPanel;
	private JButton userAvatar;
	private JPanel info;
	private JTextPane textPaneName;
	private JTextPane textPaneId;
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
	private JButton btnImport;
	private JButton btnExport;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnSearch;
	private JPanel searchPanel;
	private JButton btnRefresh;
	private JPanel medicineDetailPanel;
	private JTextField txtListOfMedicine;
	private JPanel filterPanel;
	private JComboBox cbbCategory;
	private JComboBox cbbOrigin;
	private JComboBox cbbUnitMeasure;
	private JTextField textField_1;
	private JButton btnCheckDaysExpiration;
	private JLabel lblCategory;
	private JLabel lblOrigin;
	private JLabel lblUnitMeasure;
	private JLabel lblDaysExpiration;
	private JPanel categoryPanel;
	private JPanel originPanel;
	private JPanel unitMeasurePanel;
	private JPanel DaysExpirationPanel;
	private JPanel panel_1;
	private JPanel ListMedicinePanel;
	private JScrollPane scrollPane;
	private JTable tableListMedicine;
	private JPanel contentContainer;
	private JPanel providerPanel;
	private JPanel purchaseOrderPanel;
	private JPanel customerPanel;
	private JPanel invoicePanel;
	private JPanel statisticsPanel;
	private JPanel employeeManagementPanel;
	private JPanel roleControlPanel;
	private JLabel lblNewLabel;
	private CardLayout cardLayout;

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

		contentContainer = new JPanel();
		contentPanel.add(contentContainer, BorderLayout.CENTER);

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
		btnPurchaseOrder.setHorizontalAlignment(SwingConstants.LEFT);
		btnPurchaseOrder.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnPurchaseOrder);

		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(150, 2));

		contentScrollPaneSideBar.add(separator);

		btnCustomer = new JButton("Customer");
		btnCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomer.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnCustomer);

		btnInvoice = new JButton("Invoice");
		btnInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoice.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnInvoice);

		btnStatistics = new JButton("Statistics");
		btnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistics.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnStatistics);

		separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(150, 2));
		contentScrollPaneSideBar.add(separator_1);

		btnEmployee = new JButton("Employee Magament");
		btnEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployee.setPreferredSize(new Dimension(150, 40));
		contentScrollPaneSideBar.add(btnEmployee);

		btnRoleControl = new JButton("Role Control");
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

		textPaneName = new JTextPane();

		textPaneId = new JTextPane();
		var gl_info = new GroupLayout(info);
		gl_info.setHorizontalGroup(gl_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_info.createSequentialGroup().addContainerGap()
						.addGroup(gl_info.createParallelGroup(Alignment.LEADING)
								.addComponent(textPaneName, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
								.addComponent(textPaneId, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
						.addContainerGap()));
		gl_info.setVerticalGroup(gl_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_info.createSequentialGroup().addContainerGap()
						.addComponent(textPaneName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textPaneId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		info.setLayout(gl_info);
		navigation.setLayout(gl_navigation);

		// Medicine Panel
		medicinePanel = new JPanel();
		medicinePanel.setBackground(Color.WHITE);
		medicinePanel.setLayout(new BorderLayout());
		contentContainer.add(medicinePanel, "medicinePanel");

		medicineHeadPanel = new JPanel();
		medicinePanel.add(medicineHeadPanel, BorderLayout.NORTH);
		medicineHeadPanel.setLayout(new GridLayout(0, 5, 0, 0));

		btnImport = new JButton("Import");
		medicineHeadPanel.add(btnImport);

		btnExport = new JButton("Export");
		medicineHeadPanel.add(btnExport);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "All products", "Category", "Country" }));
		comboBox.setSelectedIndex(0);
		medicineHeadPanel.add(comboBox);

		searchPanel = new JPanel();
		medicineHeadPanel.add(searchPanel);

		textField = new JTextField();
		searchPanel.add(textField);
		textField.setColumns(10);

		btnSearch = new JButton("Search");
		searchPanel.add(btnSearch);

		btnRefresh = new JButton("Refresh");
		medicineHeadPanel.add(btnRefresh);

		medicineDetailPanel = new JPanel();
		medicinePanel.add(medicineDetailPanel, BorderLayout.CENTER);
		medicineDetailPanel.setLayout(new BorderLayout(0, 0));

		txtListOfMedicine = new JTextField();
		txtListOfMedicine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtListOfMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		txtListOfMedicine.setText("List of Medicine");
		medicineDetailPanel.add(txtListOfMedicine, BorderLayout.NORTH);
		txtListOfMedicine.setColumns(10);

		filterPanel = new JPanel();
		medicineDetailPanel.add(filterPanel, BorderLayout.WEST);

		filterPanel.setPreferredSize(new Dimension(150, -1));
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS)); // Arrange vertically
		filterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the panel

		// Category
		categoryPanel = new JPanel(new BorderLayout());
		lblCategory = new JLabel("Category");
		cbbCategory = new JComboBox();
		cbbCategory.setModel(
				new DefaultComboBoxModel(new String[] { "All products", "Sore throat", "Fever", "Headache" }));
		categoryPanel.add(lblCategory, BorderLayout.NORTH);
		categoryPanel.add(cbbCategory, BorderLayout.CENTER);
		filterPanel.add(categoryPanel);

		filterPanel.add(Box.createVerticalStrut(15)); // Add vertical space

		// Origin
		originPanel = new JPanel(new BorderLayout());
		lblOrigin = new JLabel("Origin");
		cbbOrigin = new JComboBox();
		cbbOrigin.setModel(new DefaultComboBoxModel(
				new String[] { "All countries", "Vietnam", "USA", "France", "Japan", "China" }));
		originPanel.add(lblOrigin, BorderLayout.NORTH);
		originPanel.add(cbbOrigin, BorderLayout.CENTER);
		filterPanel.add(originPanel);

		filterPanel.add(Box.createVerticalStrut(15)); // Add vertical space

		// Unit of Measure
		unitMeasurePanel = new JPanel(new BorderLayout());
		lblUnitMeasure = new JLabel("Unit of Measure");
		cbbUnitMeasure = new JComboBox();
		cbbUnitMeasure.setModel(new DefaultComboBoxModel(new String[] { "All types", "Bottle", "Pack", "Bag" }));
		unitMeasurePanel.add(lblUnitMeasure, BorderLayout.NORTH);
		unitMeasurePanel.add(cbbUnitMeasure, BorderLayout.CENTER);
		filterPanel.add(unitMeasurePanel);

		filterPanel.add(Box.createVerticalStrut(15)); // Add vertical space

		// Days of Expiration
		DaysExpirationPanel = new JPanel(new BorderLayout());
		lblDaysExpiration = new JLabel("Days of Expiration");
		textField_1 = new JTextField();
		btnCheckDaysExpiration = new JButton(">");
		textField_1.setPreferredSize(new Dimension(100, 30));

		var expirationPanel = new JPanel(new BorderLayout());
		expirationPanel.add(textField_1, BorderLayout.CENTER);
		expirationPanel.add(btnCheckDaysExpiration, BorderLayout.EAST);

		DaysExpirationPanel.add(lblDaysExpiration, BorderLayout.NORTH);
		DaysExpirationPanel.add(expirationPanel, BorderLayout.CENTER);
		filterPanel.add(DaysExpirationPanel);

		panel_1 = new JPanel();
		filterPanel.add(panel_1);
		panel_1.setPreferredSize(new Dimension(150, 350));

		ListMedicinePanel = new JPanel();
		medicineDetailPanel.add(ListMedicinePanel, BorderLayout.CENTER);
		ListMedicinePanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		ListMedicinePanel.add(scrollPane);

		tableListMedicine = new JTable();
		scrollPane.setViewportView(tableListMedicine);

		providerPanel = new JPanel();
		contentContainer.add(providerPanel, "providerPanel");
		providerPanel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("Provider Panel");
		providerPanel.add(lblNewLabel, BorderLayout.CENTER);

		purchaseOrderPanel = new JPanel();
		contentContainer.add(purchaseOrderPanel, "name_1055745951998899");

		customerPanel = new JPanel();
		contentContainer.add(customerPanel, "name_1055771184865400");

		invoicePanel = new JPanel();
		contentContainer.add(invoicePanel, "name_1055803510715800");

		statisticsPanel = new JPanel();
		contentContainer.add(statisticsPanel, "name_1055821114849400");

		employeeManagementPanel = new JPanel();
		contentContainer.add(employeeManagementPanel, "name_1055854684173400");

		roleControlPanel = new JPanel();
		contentContainer.add(roleControlPanel, "name_1055893564180900");

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
}