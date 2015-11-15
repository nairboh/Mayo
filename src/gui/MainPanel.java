package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class MainPanel extends JPanel {
	public MainPanel() throws IOException {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		final Draw drawArea = new Draw();
		final ButtonPanel bp = new ButtonPanel();
		add(drawArea, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);
		drawArea.setFocusable(true);
		
		ActionListener updateColour = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				bp.colourChange(drawArea.colourValue());
				
			}
			
		};
		Timer t = new Timer(10, updateColour);
		t.start();
	}
}
