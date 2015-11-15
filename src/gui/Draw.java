package gui;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import com.thalmic.myo.*;
import com.thalmic.myo.enums.PoseType;

import myo.hubLoop;

public class Draw extends JComponent{
	Image image;
	Graphics2D graphics2D;
	int currentX, currentY, oldX, oldY;
	int colour = 0;

	public Draw(){
		setDoubleBuffered(false);

		hubLoop.hub.addListener(new AbstractDeviceListener() {  
		    @Override
		    public void onPose(Myo myo, long timestamp, Pose pose) {
		        switch (pose.getType()) {
		        	case WAVE_IN:
		        		thin();
		        		break;
		        	case WAVE_OUT:
		        		thick();
		        		break;
		        	case FINGERS_SPREAD:
						colour++;
						switch(colour) {
						case 0:
							black();
							break;
						case 1:
							red();
							break;
						case 2:
							blue();
							break;
						case 3:
							green();
							break;
						case 4:
							magenta();
							break;
						case 5:
							yellow();
							break;
						case 6:
							orange();
							break;
							
						case 8:
							// erase
							break;
						default:
							black();
							colour = 0;
						}
		        		break;
		        	default:
		        		break;
		        }
		        
		        if (pose.getType() != PoseType.FIST) {
		        	oldX = -1;
		        	oldY = -1;
		        }
		    }
		});
		
		ButtonPanel.erase.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	graphics2D.setPaint(Color.white);
	        	colour = 8;
	        	repaint();
	        }
	    });
		
		ButtonPanel.clear.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	           clear();
	        }
	    });
		
		ButtonPanel.save.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				save();
			}
		});
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				if (oldX != -1) {
					graphics2D.setStroke(new BasicStroke(main.font));
					currentX = e.getX();
					currentY = e.getY();
					if(graphics2D != null)
						graphics2D.drawLine(oldX, oldY, currentX, currentY);
					repaint();
					oldX = currentX;
					oldY = currentY;
				}
			}

		});
	}
	
	public void thick () {
		main.font += 10;
	}
	
	public void thin () {
		if (main.font - 10 >= 10) main.font -= 10;
		else main.font = 1;
	}
	
	public int colourValue() {
		return colour;
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

	public void save() {
		File outputfile = new File("image.jpg");
		try {
			ImageIO.write((BufferedImage)image, "jpg", outputfile);
		} catch (IOException e) {
		
		}
	}

	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}

	public void red(){
		graphics2D.setPaint(Color.red);
		repaint();
	}

	public void black(){
		graphics2D.setPaint(Color.black);
		repaint();
	}

	public void magenta(){
		graphics2D.setPaint(Color.magenta);
		repaint();
	}

	public void blue(){
		graphics2D.setPaint(Color.blue);
		repaint();
	}

	public void green(){
		graphics2D.setPaint(Color.green);
		repaint();
	}
	
	public void yellow(){
		graphics2D.setPaint(Color.yellow);
		repaint();
	}
	
	public void orange() {
		graphics2D.setPaint(Color.orange);
		repaint();
	}
}