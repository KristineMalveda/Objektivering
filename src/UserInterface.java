import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.JTableHeader;
//import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class UserInterface implements Runnable {

	JButton addButton;

	private JFrame frame;
	private JPanel buttonPanel, tablePanel, formPanel;
	private static CustomerTableModel model;
	private JTable jt;
	private ArrayList<JTextField> txt;

	public UserInterface() {

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

		// sort Rows by clicking column headers
		jt.setRowSorter(new TableRowSorter<CustomerTableModel>(model));
		int[] selection = jt.getSelectedRows();
		for (int i = 0; i < selection.length; i++) {
			selection[i] = jt.convertRowIndexToModel(selection[i]);
		}

		// create the table
		jt.setModel(model);

	}

	private void createComponents(Container container) {

		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);

		buttonPanel = new JPanel();
		tablePanel = new JPanel();
		formPanel = new JPanel();

		container.setLayout(layout);

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addButton = new JButton("Add new Customer");

		ButtonEvent event = new ButtonEvent();
		addButton.addActionListener(event);
		addButton.setActionCommand("add");

		buttonPanel.add(addButton);

		// jtable
		jt = new JTable(model);
//	JTableHeader header = jt.getTableHeader();
//		header.addMouseListener(new MouseEventListener(jt));

		// jt.setAutoCreateRowSorter(true);
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

				CsvReader.addData(txt.get(0).getText(), txt.get(1).getText(), txt.get(2).getText(),
						txt.get(3).getText(), txt.get(4).getText(), txt.get(5).getText(), txt.get(6).getText(),
						txt.get(7).getText());

			}
		}
	}
}
