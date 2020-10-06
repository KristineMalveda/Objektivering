import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent implements ActionListener {




	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getActionCommand().equals(UserInterface.getCommand())) {
			System.out.println("HEllo");
		}
		
		

	}
	
	
	
}
