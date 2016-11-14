import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author blanchypolangcos
 * 
 * HotelView contains a JFrame. 
 * It initializes with the JPanel ScreenInitial, and the panel is added to the frame. 
 * Each screen has buttons with action listeners.
 * 
 * The action listeners call for the controller to change the HotelView's panel
 * to a different Screen.
 * 
 * HotelView does not compile because the Screens are making calls to the controller.
 */

public class HotelView {

	JFrame frame;
	JPanel currentPan;
	HotelController controller;
	
	public HotelView() {
		controller = new HotelController();
		
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		currentPan = new ScreenInitial();
		frame.add(currentPan);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		HotelView tester = new HotelView();
	}
	
	public void changePanel(JPanel jp) {
		currentPan = jp;
		frame.repaint();
	}
	
	
}
