import javax.swing.*;


public class ScreenGuest extends JPanel {

	private HotelController controller;
	
	public ScreenGuest() {
		controller = new HotelController();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel guest = new JLabel("Guest User Options:", SwingConstants.CENTER);
		JButton signUp = new JButton("Sign Up");
		JButton signIn = new JButton("Sign In");
		JButton goBack = new JButton("Go Back");
		
		signUp.addActionListener(controller.changeScreen(new ScreenUserID()));
		signIn.addActionListener(controller.changeScreen(new ScreenUserID()));
		goBack.addActionListener(controller.changeScreen(new ScreenInitial()));
		
		add(guest);
		add(signUp);
		add(signIn);
		add(goBack);
	}
	
}
