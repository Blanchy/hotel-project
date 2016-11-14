import javax.swing.*;


public class ScreenManager extends JPanel {

	private HotelController controller;
	
	public ScreenManager() {
		controller = new HotelController();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel manageOption = new JLabel("Manager Options:", SwingConstants.CENTER);
		JButton load = new JButton("Load"); // add pop-up confirming successful load
		JButton view = new JButton("View");
		JButton save = new JButton("Save"); // add pop-up confirming successful save
		JButton quit = new JButton("Quit");
		
		view.addActionListener(controller.changeScreen(new ScreenManagerView()));
		// quit.addActionListener
		
		add(manageOption);
		add(load);
		add(view);
		add(save);
		add(quit);
	}

}
