package screens;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyScreen extends Screen{
	
	public MyScreen() {
		init();
	}
	
	private void init() {
		lbButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
			}
		});
		
		lbButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
			}
		});
		
		lbButtonSqrt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
			}
		});
	}
	
	// sets the current value
	public void setCurrentValue(int value) {
		lbCurrentValue.setText("" + value);
	}	
	
}
