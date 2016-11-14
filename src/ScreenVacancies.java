import java.awt.*;

import javax.swing.*;


public class ScreenVacancies extends JPanel {

	HotelController controller; 
	
	public ScreenVacancies() {
		
		controller = new HotelController();
		setLayout(new FlowLayout());
		
		JPanel vacancies = new JPanel();
		
		vacancies.setLayout(new FlowLayout());
		JTextArea rooms = new JTextArea("Room vacancies will go here");
		vacancies.add(rooms);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		JLabel enterPrompt = new JLabel("Enter room number:");
		JTextField enterRoom = new JTextField();
		JButton reserve = new JButton("Confirm Reservation");
		JButton back = new JButton("Go Back");
		
		reserve.addActionListener(controller.changeScreen(new ScreenReceiptOptions()));
		back.addActionListener(controller.changeScreen(new ScreenMakeRes()));
		
		buttons.add(enterPrompt);
		buttons.add(enterRoom);
		buttons.add(reserve);
		buttons.add(back);
		
		add(vacancies);
		add(buttons);
	}

}
