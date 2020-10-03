import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserInterface implements Runnable {

	JButton showButton, sortButton, saveButton;

	private JFrame frame;
	private JPanel buttonPanel, tablePanel;
	private JTable jtable;
	ArrayList<String> columnnames;

	public UserInterface() {

	}

	@Override
	public void run() {
		frame = new JFrame("CSV");
		frame.setPreferredSize(new Dimension(700, 200));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	private void createComponents(Container container) {

		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);

		// create a GUI with corresponding action listeners
		buttonPanel = new JPanel();
		tablePanel = new JPanel();

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		showButton = new JButton("Show Table");
		showButton.addActionListener(new ButtonEvent());
		sortButton = new JButton("Sort Alphabetically");
		sortButton.addActionListener(new ButtonEvent());
		saveButton = new JButton("Save the file");
		saveButton.addActionListener(new ButtonEvent());

		buttonPanel.add(showButton);
		buttonPanel.add(sortButton);
		buttonPanel.add(saveButton);

		container.add(buttonPanel, BorderLayout.NORTH);

		String column[] = { "OrderDate", "Region", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total" };
		String data[][] = { { "101", "Amit", "670000","101", "Amit", "670000", "k", "m" }, { "102", "Jai", "780000","101", "Amit", "670000", "k", "m"  }, { "101", "Sachin", "700000","101", "Amit", "670000", "k" , "m" } };

		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		tablePanel.add(sp);
		tablePanel.setSize(300, 400);
		tablePanel.setVisible(true);

		
		  ArrayList<ArrayList<String>> myWholeSheet = CsvReader.getWholeSheet();
		  
		  for (int i = 0; i < myWholeSheet.size(); i++) { ArrayList<String> myRow =
 	  myWholeSheet.get(i);
		  
		  for (int j = 0; j < myRow.size(); j++) {
		 
		  } System.out.println(myRow);	  
		  }
		 
		//columnnames = myWholeSheet.get(0);

		container.add(tablePanel, BorderLayout.SOUTH);

	}

	public class ButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == showButton) {
				CsvReader.getWholeSheet();

			}
			if (e.getSource() == sortButton) {

				System.out.println("Sort the file");
			}
			if (e.getSource() == saveButton) {

				System.out.println("Save the file");
			}
		}
	}
}
