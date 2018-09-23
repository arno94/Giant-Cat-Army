package screens;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	// sets the current value
	public void setCurrentValue(int value) {
		lbCurrentValue.setText("" + value);
	}	
	
}
