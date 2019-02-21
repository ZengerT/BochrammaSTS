package hmi;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7352765167983590088L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component comp = super.getTableCellRendererComponent(table, value,
				hasFocus, hasFocus, column, column);

		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);

		return comp;
	}

}
