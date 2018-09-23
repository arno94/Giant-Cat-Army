package screens.entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	  private Image img;
	  private Dimension dimension;

	  public ImagePanel(String img, Dimension size) {
	    this(new ImageIcon(img).getImage(), size);
	  }

	  public ImagePanel(Image img, Dimension size) {
		this.dimension = size;
	    this.img = img.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);	  	   
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);	    
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, this);
	  }

	}
