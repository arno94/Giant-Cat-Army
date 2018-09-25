package screens;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import screens.entity.ImagePanel;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class Screen {

	private JFrame frame;
	
	// dimensions
	private int WIDTH;
	private int HEIGHT;
	
	// contains current value
	protected JLabel lbCurrentValue;
	
	// button for handling events
	protected JLabel lbButton5;
	protected JLabel lbButton7;
	protected JLabel lbButtonSqrt;	
	
	protected JLabel lbGoal1;
	protected JLabel lbGoal2;
	protected JLabel lbGoal3;
	
	protected JLabel lbUsedValues;
	protected JLabel lbEndQuote;
	
	/**
	 * Create the application.
	 */
	public Screen() {
		try {
			init();
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		JFrame.setDefaultLookAndFeelDecorated(true);		
		
		frame = new JFrame();
		frame.setType(Type.NORMAL);
		
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		//frame.setUndecorated(true);		
		
		frame.pack();		
		frame.setVisible(true);		
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
//		frame = new JFrame();
//		//frame.setSize(WIDTH, HEIGHT);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		frame.setLocationRelativeTo(null);		
		//frame.setResizable(false);		
		
		WIDTH = frame.getWidth();
		HEIGHT = frame.getHeight();					
				
		ImagePanel panel = new ImagePanel(new ImageIcon("images/bg.png").getImage(), new Dimension(frame.getWidth(), frame.getHeight()));
		
		frame.getContentPane().add(panel);		
		
		JLabel lbGameName = new JLabel(new ImageIcon("images/app_name.png"));		
		lbGameName.setLocation(0, 10);
		lbGameName.setSize(WIDTH, 100);
		lbGameName.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameName.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lbGameName);
		
		lbUsedValues = new JLabel("", SwingConstants.CENTER);
		lbUsedValues.setForeground(Color.WHITE);
		lbUsedValues.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbUsedValues.setLocation(10, 2*(HEIGHT/6));
		
		lbUsedValues.setSize(WIDTH - 20, 150);
		panel.add(lbUsedValues);
		
		
		Box horizontalBoxCurrentValue = Box.createHorizontalBox();		
		horizontalBoxCurrentValue.setBounds(10, HEIGHT/2, WIDTH - 20, 150);
		panel.add(horizontalBoxCurrentValue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBoxCurrentValue.add(horizontalGlue_1);
		
		lbCurrentValue = new JLabel("0");
		horizontalBoxCurrentValue.add(lbCurrentValue);
		lbCurrentValue.setForeground(new Color(255, 255, 255));
		lbCurrentValue.setFont(new Font("Carter One", Font.BOLD, 65));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBoxCurrentValue.add(horizontalGlue);
		
		Box horizontalBoxButtons = Box.createHorizontalBox();
		horizontalBoxButtons.setBounds(10, 4*(HEIGHT/6), WIDTH - 20, 150);
		panel.add(horizontalBoxButtons);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBoxButtons.add(horizontalBox_1);
		
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
		
		Box horizontalBoxGoals = Box.createHorizontalBox();
		horizontalBoxGoals.setBounds(10, (HEIGHT/6), WIDTH - 20, 150);
		panel.add(horizontalBoxGoals);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBoxGoals.add(horizontalBox_4);
		
		Component horizontalGlue_8 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_8);
		
		Component horizontalGlue_9 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_9);
		
		lbGoal1 = new JLabel();
		lbGoal1.setIcon(new ImageIcon("images/goals/goal2_.png"));			
		lbGoal1.setBorder(null);
		horizontalBox_4.add(lbGoal1);
		
		Component horizontalGlue_10 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_10);
		
		lbGoal2 = new JLabel();
		lbGoal2.setIcon(new ImageIcon("images/goals/goal10_.png"));	
		lbGoal2.setBorder(null);
		horizontalBox_4.add(lbGoal2);
		
		Component horizontalGlue_11 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_11);
		
		lbGoal3 = new JLabel();
		lbGoal3.setIcon(new ImageIcon("images/goals/goal14_.png"));	
		lbGoal3.setBorder(null);
		horizontalBox_4.add(lbGoal3);
		
		Component horizontalGlue_12 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_12);
		
		Component horizontalGlue_13 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_13);
		
		lbEndQuote = new JLabel("", SwingConstants.CENTER);
		lbEndQuote.setBounds(30, HEIGHT - 200, WIDTH - 60, 150);
		lbEndQuote.setForeground(new Color(255, 255, 255));
		lbEndQuote.setFont(new Font("Carter One", Font.BOLD, 30));
		panel.add(lbEndQuote);
		
	    frame.pack();
	    frame.repaint();
	    
	    //frame.setVisible(true);		  	   	   
	}
}
