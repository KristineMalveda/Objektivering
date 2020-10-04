import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;


public class UserInterface implements Runnable {

	JButton saveButton;

	private JFrame frame;
	private JPanel buttonPanel, tablePanel;
	// ArrayList<String> columnnames;
	public static CustomerTableModel model;

	private JTable jt;

	public UserInterface() {

	}

	@Override
	public void run() {
		frame = new JFrame("CSV");
		frame.setPreferredSize(new Dimension(700, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		ArrayList<CustomerData> mywholeSheet = CsvReader.loadCSV();

		// create the model
		model = new CustomerTableModel(mywholeSheet);

		// create the table
		jt.setModel(model);

	}

	private void createComponents(Container container) {

		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);

		// create a GUI with corresponding action listeners
		buttonPanel = new JPanel();
		tablePanel = new JPanel();

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		saveButton = new JButton("Save the file");
		saveButton.addActionListener(new ButtonEvent());

		buttonPanel.add(saveButton);

		container.add(buttonPanel, BorderLayout.NORTH);

		jt = new JTable(model);

		jt.setAutoCreateRowSorter(true);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		sp.setPreferredSize(new Dimension(700, 500));
		tablePanel.add(sp);
		tablePanel.setVisible(true);

		container.add(tablePanel, BorderLayout.CENTER);

	}


}
