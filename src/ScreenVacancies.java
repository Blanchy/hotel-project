import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenVacancies extends JPanel {

	HotelView view; 
	
	public ScreenVacancies(HotelView v) {
		
		view = v;
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
		
		reserve.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenReceiptOptions(view));

			}

		});
		
		back.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenMakeRes(view));

			}

		});
		
		buttons.add(enterPrompt);
		buttons.add(enterRoom);
		buttons.add(reserve);
		buttons.add(back);
		
		add(vacancies);
		add(buttons);
	}

}
