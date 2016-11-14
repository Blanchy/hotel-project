import java.awt.*;
import javax.swing.*;

public class ScreenReceiptOptions extends JPanel {

	private HotelController controller;
	
	public ScreenReceiptOptions() {
		controller  = new HotelController();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel option = new JLabel("Choose format of reciept:");
		JButton simple = new JButton("Simple");
		JButton comprehensive = new JButton("Comprehensive");
		
		simple.addActionListener(controller.changeScreen(new ScreenReceipt()));
		comprehensive.addActionListener(controller.changeScreen(new ScreenReceipt()));
		
		add(option);
		add(simple);
		add(comprehensive);
	}
}
