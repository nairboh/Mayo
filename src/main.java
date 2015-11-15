import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.thalmic.myo.*;
import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Vector3;

public class main {  
	public static hubLoop h;
	public static int frameWidth = 800;
	public static int frameHeight = 600;
	
    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
    	  public void run() {
    		  h = new hubLoop();
    		  (new Thread(h)).start();
    		  
    		  Myo myo = hubLoop.hub.waitForMyo(10000);

        	  JFrame startMain;
        	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        	  
        	  try {
        		  startMain = new MainFrame("Mayo Drawing Board");
        		  startMain.setResizable(false);
        		  startMain.setSize(frameWidth, frameHeight);
        		  startMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		  startMain.setLocationRelativeTo(null);
        		  startMain.setVisible(true);
        	  } catch(IOException ioe) {

        	  }
        	  	
          }
      });
    }
}