package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen extends JFrame {
    private JLabel splash;  
    
    public SplashScreen() {
    	initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        try { 
        	Thread.sleep(4000); 
        } catch (Exception e) {
        	
        }
        setVisible(false);
    }
    
    private void initComponents() {
    	setUndecorated(true);
        splash = new JLabel();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

    	splash.setIcon(new javax.swing.ImageIcon(getClass().getResource("mayo.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(splash)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(splash)
                .addGap(0, 0, 0))
        );
        pack();
   }                                                    
}
