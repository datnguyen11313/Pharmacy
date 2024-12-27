package utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class UIHelper {

	public static JButton createStyledButton(String text) {
		var button = new JButton(text);
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(150, 40));
		button.setBackground(new Color(60, 63, 65)); // Màu nút
		button.setForeground(Color.WHITE); // Màu chữ trắng
		button.setFocusPainted(false);
		button.setBorderPainted(false);

		// Hover effect
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(new Color(15, 240, 172)); // Màu khi hover
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(new Color(60, 63, 65)); // Màu gốc
			}
		});

		return button;
	}
}
