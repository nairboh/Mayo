import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import com.sun.xml.internal.ws.api.server.Container;


public class MainPanel extends JPanel {
	public MainPanel() throws IOException {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		final Draw drawArea = new Draw();
		final ButtonPanel bp = new ButtonPanel();
		add(drawArea, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);
		drawArea.setFocusable(true);
	}
}
