package screens;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import helper.StringHelper;
import main.Main;
import screens.entity.ImagePanel;
import java.awt.Color;
import java.awt.Font;

public class MainMenu {

	private JFrame frame;
	
	private JLabel lbStart;
	
	private int WIDTH;
	private int HEIGHT;

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Init frame options
		JFrame.setDefaultLookAndFeelDecorated(true);		
		
		frame = new JFrame();
		frame.setType(Type.NORMAL);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		//frame.setUndecorated(true);		
		
		frame.pack();		
		frame.setVisible(true);	
		
		WIDTH = frame.getWidth();
		HEIGHT = frame.getHeight();
		
		// Main image
		ImagePanel panel = new ImagePanel(new ImageIcon("images/bg.png").getImage(), new Dimension(WIDTH, HEIGHT));
		
		frame.getContentPane().add(panel);
		
		JLabel lbGameName = new JLabel(new ImageIcon("images/app_name.png"));		
		lbGameName.setLocation(0, 10);
		lbGameName.setSize(WIDTH, 100);
		lbGameName.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameName.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lbGameName);
		
		JLabel lbQuest = new JLabel(StringHelper.q);		
		lbQuest.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbQuest.setForeground(Color.WHITE);
		lbQuest.setLocation(200, 150);
		lbQuest.setSize(WIDTH - 400, HEIGHT - 250);
		lbQuest.setHorizontalAlignment(SwingConstants.CENTER);
		lbQuest.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lbQuest);
		
		lbStart = new JLabel();
		lbStart.setBounds(WIDTH/2 - 100, HEIGHT - 180, 200, 60);		
		lbStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				Main.createScreen();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lbStart.setIcon(new ImageIcon("images/buttons/start_btn_clicked.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbStart.setIcon(new ImageIcon("images/buttons/start_btn.png"));
			}
		});
		lbStart.setBorder(null);
		lbStart.setIcon(new ImageIcon("images/buttons/start_btn.png"));		
		panel.add(lbStart);
		
		frame.pack();
		frame.repaint();
	}		

}
