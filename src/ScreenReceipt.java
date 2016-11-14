import java.awt.*;

import javax.swing.*; 

public class ScreenReceipt extends JPanel {

	private HotelController controller;
	
	public ScreenReceipt() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JTextArea receipt = new JTextArea("Formatted reciept printed here");
		JButton menu = new JButton("Return to Guest Menu");
		
		menu.addActionListener(controller.changeScreen(new ScreenGuestOptions()));
		
		add(receipt);
		add(menu);
	}

}
