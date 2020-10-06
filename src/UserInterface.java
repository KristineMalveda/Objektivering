import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.opencsv.exceptions.CsvValidationException;

public class UserInterface implements Runnable {

	JButton saveButton, addButton;

	private JFrame frame;
	private JPanel buttonPanel, tablePanel, formPanel;
	private static CustomerTableModel model;
	private JTable jt;
	private ArrayList<JTextField> txt;
	private static String command = "add";

	public UserInterface() {

	}

	public static String getCommand() {
		return command;
	}

	@Override
	public void run() {
		frame = new JFrame("CSV");
		frame.setPreferredSize(new Dimension(600, 400));
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

		// create a GUI with corresponding action listeners
		buttonPanel = new JPanel();
		tablePanel = new JPanel();
		formPanel = new JPanel();

		container.setLayout(layout);

		// buttons

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addButton = new JButton("Add new Customer");

		ButtonEvent event = new ButtonEvent();
		addButton.addActionListener(event);
		addButton.setActionCommand("add");

		saveButton = new JButton("Save the file");
		ButtonEvent event2 = new ButtonEvent();
		saveButton.addActionListener(event2);
		addButton.setActionCommand("save");

		buttonPanel.add(addButton);
		buttonPanel.add(saveButton);

		// jtable
		jt = new JTable(model);
		jt.setAutoCreateRowSorter(true);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		sp.setPreferredSize(new Dimension(700, 500));
		tablePanel.add(sp);
		tablePanel.setVisible(true);

		String[] textfieldNames = { null, null, null, null, null, null, null, null };
		String[] textLabelNames = { "orderDate", "region", "rep1", "rep2", "item", "units", "unitCost", "total" };
		// textFields
		txt = new ArrayList<JTextField>();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();

		for (int i = 0; i < textfieldNames.length; i++) {
			txt.add(new JTextField(textfieldNames[i]));
			txt.get(i).setPreferredSize(new Dimension(50, 20));
			labels.add(new JLabel(textLabelNames[i]));
			formPanel.add(labels.get(i));
			formPanel.add(txt.get(i));
		}

		container.add(formPanel, BorderLayout.SOUTH);
		container.add(buttonPanel, BorderLayout.NORTH);
		container.add(tablePanel, BorderLayout.CENTER);

	}

	public class ButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == addButton) {
				for (int i = 0; i < txt.size(); i++) {
					
				}
				try {
					try {
						CsvReader.addData( txt.get(0).getText(), txt.get(1).getText(), txt.get(2).getText(),
								txt.get(3).getText(), txt.get(4).getText(), txt.get(5).getText(), txt.get(6).getText(),
								txt.get(7).getText());
					} catch (CsvValidationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			 	
			
		}
	}
}
