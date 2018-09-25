package screens;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.Main;

public class MyScreen extends Screen{
	
	public MyScreen() {
		init();
	}
	
	private void init() {
		lbButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Main.check(5);
			}
		});
		
		lbButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Main.check(7);
			}
		});
		
		lbButtonSqrt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Main.check(1);
			}
		});
	}
	
	public void goalReached(int id) {
		switch(id) {
		case 1:
			lbGoal1.setIcon(new ImageIcon("images/goals/goal2.png"));	
			break;
		case 2:
			lbGoal2.setIcon(new ImageIcon("images/goals/goal10.png"));	
			break;
		case 3:
			lbGoal3.setIcon(new ImageIcon("images/goals/goal14.png"));	
			break;
		}
	}
	
	/**
	 * Sets the current value
	 * @param value
	 */
	public void setCurrentValue(int value) {
		lbCurrentValue.setText("" + value);		
	}
	
	/**
	 * Change color of the current value
	 * @param color
	 */
	public void setCurrentValueColor(Color color) {
		lbCurrentValue.setForeground(color);
	}
	
	public void setUsedValues(ArrayList<Integer> values) {
		String s = "";
		for(int i = 0;i < values.size(); i++) {
			if(i == 0) s += values.get(i);
			else s += ", " + values.get(i);
		}
		lbUsedValues.setText(s);
	}
	
	public void setEndQuote(Color color, String text) {
		lbEndQuote.setForeground(color);
		lbEndQuote.setText(text);
	}
	
}
