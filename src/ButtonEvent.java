import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonEvent implements ActionListener {

	private static JButton showButton, sortButton, saveButton;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == showButton) {
		//	CsvReader.getWholeSheet();
			System.out.println("test show button");	
		}
		
		if(e.getSource() == sortButton) {
			
			System.out.println("Sort the file");
		}
		if(e.getSource() == saveButton) {
			
			System.out.println("Save the file");
		}

	}

}
