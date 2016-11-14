import javax.swing.*;


public class ScreenUserID extends JPanel {

	private HotelController controller;
	
	public ScreenUserID() {
		controller = new HotelController();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel userPrompt = new JLabel("Enter User ID (numbers and letters ONLY):");
		JTextField input = new JTextField();
		JButton enter = new JButton("Continue");
		
		enter.addActionListener(controller.changeScreen(new ScreenGuestOptions()));
		
		add(userPrompt);
		add(input);
		add(enter);
	}
}
