import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {
	
	private JFrame frame;
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
		
		
	}
}
