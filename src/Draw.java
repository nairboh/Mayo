import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.thalmic.myo.*;
import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Vector3;

public class Draw extends JComponent{
	final int X_MULT = 100;
	final int Y_MULT = 100;
	
	Image image;
	//this is gonna be your image that you draw on
	Graphics2D graphics2D;
	//this is what we'll be using to draw on
	//these are gonna hold our mouse coordinates
	
	public static Vector3 position = new Vector3();
	public static Vector3 velocity = new Vector3();


	//Now for the constructors
	public Draw(){
		setDoubleBuffered(false);
			
	    main.hub.addListener(new AbstractDeviceListener() {
	        @Override
	        public void onAccelerometerData(Myo myo, long timestamp, Vector3 vector) {
	        	velocity = vectorAdd (velocity, vectorClearNoise(vector));
	        	
	        	int oldX =(int)(Math.round(position.getY() * X_MULT));
	        	int oldY =(int)(Math.round(position.getZ()*Y_MULT));
	        	position = vectorAdd (velocity,position);
	        	int newX =(int)(Math.round(position.getY() * X_MULT));
	        	int newY =(int)(Math.round(position.getZ()*Y_MULT));
	        	System.out.println(position);
	            
	            if(graphics2D != null)
					graphics2D.drawLine(oldX,oldY,newX,newY);
				repaint();
	        }
	    });
	    
				

	}
	
	public static Vector3 vectorClearNoise (Vector3 v) {
		return new Vector3 (v.getX() >= 1 ? v.getX() : 0, v.getY() >= 1 ? v.getY() : 0, v.getZ() >= 1 ? v.getZ() : 0);
	}
	
	public static Vector3 vectorAdd (Vector3 v1, Vector3 v2) {
		return new Vector3 (v1.getX() + v2.getX(), v1.getY() + v2.getY(),v1.getZ() + v2.getZ());
	}

	public void paintComponent(Graphics g){
		if(image == null){
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}
	//this is the painting bit
	//if it has nothing on it then
	//it creates an image the size of the window
	//sets the value of Graphics as the image
	//sets the rendering
	//runs the clear() method
	//then it draws the image


	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	//this is the clear
	//it sets the colors as white
	//then it fills the window with white
	//thin it sets the color back to black
	public void red(){
		graphics2D.setPaint(Color.red);
		repaint();
	}
	//this is the red paint
	public void black(){
		graphics2D.setPaint(Color.black);
		repaint();
	}
	//black paint
	public void magenta(){
		graphics2D.setPaint(Color.magenta);
		repaint();
	}
	//magenta paint
	public void blue(){
		graphics2D.setPaint(Color.blue);
		repaint();
	}
	//blue paint
	public void green(){
		graphics2D.setPaint(Color.green);
		repaint();
	}
	//green paint

}