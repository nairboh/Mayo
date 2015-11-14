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
    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
    	  public void run() {
        	  final int frameWidth = 800;
        	  final int frameHeight = 600;
        	  JFrame startMain;
        	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        	  try{
        		  startMain = new MainFrame("Mayo");
        		  startMain.setResizable(false);
        		  startMain.setSize(frameWidth, frameHeight);
        		  startMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		  startMain.setVisible(true);
        		  startMain.setLocation(screenSize.width / 2 - frameWidth / 2, screenSize.height / 2 - frameHeight / 2);
        	  } catch(IOException ioe) {

        	  }
        	  	
          }
      });
     
    }
}