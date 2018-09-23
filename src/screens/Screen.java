package screens;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import screens.entity.ImagePanel;

public class Screen {

	private JFrame frame;
	
	// dimensions
	private final int WIDTH = 1024;
	private final int HEIGHT = 768;
	
	// contains current value
	protected JLabel lbCurrentValue;
	
	// button for handling events
	protected JLabel lbButton5;
	protected JLabel lbButton7;
	protected JLabel lbButtonSqrt;
	
	/**
	 * Create the application.
	 */
	public Screen() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		ImagePanel panel = new ImagePanel(new ImageIcon("images/bg.png").getImage(), new Dimension(WIDTH, HEIGHT));
		
		frame.getContentPane().add(panel);		
		
		JLabel lbGameName = new JLabel(new ImageIcon("images/app_name.png"));		
		lbGameName.setLocation(12, 13);
		lbGameName.setSize(1000, 100);
		lbGameName.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lbGameName);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(12, 297, 1000, 126);
		panel.add(horizontalBox);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		lbCurrentValue = new JLabel("0");
		horizontalBox.add(lbCurrentValue);
		lbCurrentValue.setForeground(new Color(255, 255, 255));
		lbCurrentValue.setFont(new Font("Carter One", Font.BOLD, 40));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBounds(12, 436, 1000, 132);
		panel.add(horizontalBox_2);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_2.add(horizontalBox_1);
		
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_7);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);
		
		lbButton5 = new JLabel();
		lbButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbButton5.setIcon(new ImageIcon("images/buttons/btn5_clicked.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbButton5.setIcon(new ImageIcon("images/buttons/btn5.png"));
			}
		});
		lbButton5.setBorder(null);
		lbButton5.setIcon(new ImageIcon("images/buttons/btn5.png"));
		lbButton5.setFont(new Font("Tahoma", Font.BOLD, 30));
		horizontalBox_1.add(lbButton5);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_4);
		
		lbButton7 = new JLabel();		
		lbButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbButton7.setIcon(new ImageIcon("images/buttons/btn7_clicked.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbButton7.setIcon(new ImageIcon("images/buttons/btn7.png"));
			}
		});
		lbButton7.setBorder(null);
		lbButton7.setIcon(new ImageIcon("images/buttons/btn7.png"));		
		horizontalBox_1.add(lbButton7);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_5);
		
		lbButtonSqrt = new JLabel();
		lbButtonSqrt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbButtonSqrt.setIcon(new ImageIcon("images/buttons/btns_clicked.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbButtonSqrt.setIcon(new ImageIcon("images/buttons/btns.png"));
			}
		});
		lbButtonSqrt.setBorder(null);
		lbButtonSqrt.setIcon(new ImageIcon("images/buttons/btns.png"));		
		horizontalBox_1.add(lbButtonSqrt);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_6);
		
	    frame.pack();	 	    
	    
	    frame.setVisible(true);		  
	}
}
