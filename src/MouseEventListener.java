import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MouseEventListener extends MouseAdapter {

		private JTable table;
		


		public MouseEventListener(JTable table) {
			this.table = table;
			
		}

		public void mouseClicked(MouseEvent event) {
			final JTableHeader header = (JTableHeader) event.getComponent();

			int column = header.columnAtPoint(event.getPoint());

			String name = table.getColumnName(column);
			JOptionPane.showMessageDialog(null, name + ":" + column);
			TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
			sorter.isSortable(column);
		

		}
}
