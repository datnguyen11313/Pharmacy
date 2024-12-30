package utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class UIHelper {

	public static void styleButton(JButton button) {
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(150, 100));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setFocusPainted(false);
		button.setBorderPainted(true);

		// Hover effect
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(new Color(15, 240, 172));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(Color.WHITE);
			}
		});
	}
}