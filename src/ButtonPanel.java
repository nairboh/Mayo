import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel {
	static JButton erase = new JButton("Erase");
	static JButton clear = new JButton("Clear");
	static JButton save = new JButton("Save");
	JButton colour = new JButton(" ");
	
	public ButtonPanel() throws IOException {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.CENTER;
		
		colour.setBackground(Color.BLACK);
		colour.setPreferredSize(new Dimension(80, 30));
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(save, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(erase, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		add(clear, gc);
	}
	
	public void colourChange(int c) {
		switch(c) {
			
		case 0:
			colour.setText(" ");
			colour.setBackground(Color.BLACK);
			break;
		case 1:
			colour.setText(" ");
			colour.setBackground(Color.RED);
			break;
		case 2:
			colour.setText(" ");
			colour.setBackground(Color.BLUE);
			break;
		case 3:
			colour.setText(" ");
			colour.setBackground(Color.GREEN);
			break;
		case 4:
			colour.setText(" ");
			colour.setBackground(Color.WHITE);
			colour.setText("Erase");
			break;
		default:
			colour.setText(" ");
			colour.setBackground(Color.BLACK);
		}
	}
}
