import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel {
	static JButton erase = new JButton("Erase");
	static JButton clear = new JButton("Clear");
	JButton draw = new JButton("Draw");
	
	public ButtonPanel() throws IOException {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.CENTER;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(draw, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(erase, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		add(clear, gc);
	}
}
