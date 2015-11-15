package gui;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import myo.hubLoop;


public class main {  
	
	static int font = 10;
	static hubLoop h;
	static final int frameWidth = 800;
	static final int frameHeight = 600;
	static JFrame startMain;
	static SplashScreen splash;
	
    public static void main(String[] args) {
    	splash = new SplashScreen();
    	h = new hubLoop();
		(new Thread(h)).start();
		  
      SwingUtilities.invokeLater(new Runnable() {
    	  public void run() {
        	  JFrame startMain;
        	  try {
        		  startMain = new MainFrame("Mayo");
        		  startMain.setAlwaysOnTop(true);
        		  startMain.setSize(frameWidth, frameHeight);
        		  startMain.setResizable(false);
        		  startMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		  startMain.setLocationRelativeTo(null);
        		  startMain.setVisible(true);
        	  } catch(IOException ioe) {
        		  System.out.println("Unable to Create GUI");
        	  } 	
          }
      });
    }
}