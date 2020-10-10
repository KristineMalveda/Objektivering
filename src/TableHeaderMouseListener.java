
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JTable;

public class TableHeaderMouseListener extends MouseAdapter {
	private JTable table;
	private ArrayList<CustomerData> customerList = CsvReader.customerList;

	public TableHeaderMouseListener(JTable table) {
		this.table = table;
	}

	public void mouseClicked(MouseEvent event) {
		Point point = event.getPoint();
		int column = table.columnAtPoint(point);

		//JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked");

		switch (column) {

		case 0:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getOrderDate().compareTo(o2.getOrderDate());
				};

			});

			break;

		case 1:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getRegion().compareTo(o2.getRegion());
				};

			});
			break;
		case 2:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getRep1().compareTo(o2.getRep1());
				};

			});
			break;

		case 3:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getRep2().compareTo(o2.getRep2());
				};

			});
			break;

		case 4:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getItem().compareTo(o2.getItem());
				};

			});
			break;

		case 5:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getUnits().compareTo(o2.getUnits());
				};

			});
			break;
		case 6:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getUnitCost().compareTo(o2.getUnitCost());
				};

			});
			break;
		case 7:
			Collections.sort(customerList, new Comparator<CustomerData>() {
				public int compare(CustomerData o1, CustomerData o2) {
					// TODO Auto-generated method stub
					return o1.getTotal().compareTo(o2.getTotal());
				};

			});
			break;
		}
	}

}
