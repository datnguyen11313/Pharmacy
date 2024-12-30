package utils;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

	public ButtonRenderer() {
		setOpaque(true); // Đảm bảo button hiển thị nền
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText((value == null) ? "" : value.toString()); // Hiển thị tên thuốc trên button
		// Tùy chỉnh giao diện button (màu sắc, font chữ...)
		if (isSelected) {
			setBackground(table.getSelectionBackground());
			setForeground(table.getSelectionForeground());
		} else {
			setBackground(table.getBackground());
			setForeground(table.getForeground());
		}

		setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10)); // top, left, bottom, right

		return this;
	}
}
