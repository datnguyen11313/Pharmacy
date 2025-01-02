package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.ConnectDB;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("LoginForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel loginform = new JPanel();
		loginform.setBounds(0, 0, 322, 460);
		contentPane.add(loginform);
		loginform.setLayout(null);

		JLabel loginUsername = new JLabel("Username :");
		loginUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginUsername.setBounds(39, 112, 93, 35);
		loginform.add(loginUsername);

		JLabel password = new JLabel("Password :");
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(39, 188, 85, 14);
		loginform.add(password);

		textField = new JTextField();
		textField.setBounds(39, 148, 180, 29);
		loginform.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(39, 213, 180, 29);
		loginform.add(passwordField);

		JLabel lblNewLabel = new JLabel("PharmaStore");
		lblNewLabel.setBounds(28, 28, 284, 94);
		loginform.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 160));
		lblNewLabel.setForeground(new Color(15, 240, 172));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setIconTextGap(10);
		lblNewLabel.setIcon(new ImageIcon("D:\\pharmacy\\src\\main\\resources\\img\\iconLogin.png"));

		JButton btnLogin = new JButton("LOG IN");
		btnLogin.setIcon(new ImageIcon("D:\\pharmacy\\src\\main\\resources\\img\\iconloginbutton.png"));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());

				// Kết nối với cơ sở dữ liệu và xác thực
				Connection conn = ConnectDB.getCon(); // Sử dụng kết nối từ ConnectDB

				if (conn != null) {
					String query = "SELECT * FROM users WHERE username = ? AND password = ?";

					try (PreparedStatement stmt = conn.prepareStatement(query)) {
						stmt.setString(1, username); // Thêm tên đăng nhập vào câu truy vấn
						stmt.setString(2, password); // Thêm mật khẩu vào câu truy vấn

						ResultSet rs = stmt.executeQuery();

						if (rs.next()) {
							// Đăng nhập thành công
							String role = rs.getString("role_id"); // Lấy role_id từ cơ sở dữ liệu
							JOptionPane.showMessageDialog(null, "Login Successful");

							// Chuyển đến Main với role tương ứng
							Main mainFrame = new Main(role); // Truyền role vào Main
							mainFrame.setVisible(true); // Hiển thị giao diện Main

							dispose(); // Đóng cửa sổ login sau khi đăng nhập thành công
						} else {
							// Đăng nhập thất bại
							JOptionPane.showMessageDialog(null, "Invalid username or password");
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Database connection failed!");
				}
			}
		});
		btnLogin.setFont(new Font("Wide Latin", Font.PLAIN, 10));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(15, 240, 172));
		btnLogin.setBounds(39, 272, 180, 46);
		loginform.add(btnLogin);

		JPanel bannerform = new JPanel();
		bannerform.setBackground(new Color(0, 0, 0));
		bannerform.setBounds(321, 0, 401, 460);
		contentPane.add(bannerform);
		bannerform.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\pharmacy\\src\\main\\resources\\img\\bannerlogin.jpg"));
		lblNewLabel_1.setBounds(0, 0, 401, 460);
		bannerform.add(lblNewLabel_1);
	}
}
