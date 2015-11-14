import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	JButton thin;
	JButton bold;
	JButton eraser;
	
	public MainFrame(String title) throws IOException {
		super(title);
		setLayout(new BorderLayout());
		final MainPanel m = new MainPanel();

		final Container c = getContentPane();
		c.add(m, BorderLayout.CENTER);
		
		
	}

}
