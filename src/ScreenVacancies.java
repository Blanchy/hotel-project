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
		JTextArea rooms = new JTextArea();
		rooms.setText(printRooms());
		/* add a change listener for when the preference of rooms gets changed? set it to call
		 * printrooms
		 */
		
		vacancies.add(rooms);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		JLabel enterPrompt = new JLabel("Enter room number:");
		JTextField enterRoom = new JTextField();
		JButton confirm = new JButton("Confirm");
		JButton	moreReservations = new JButton("More reservations?");
		JButton done = new JButton("Done");
		JButton back = new JButton("Go Back");
		
		confirm.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				//add reservation
				//update vacancies to get new vacant rooms

			}

		});
		
		moreReservations.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				JFrame popup = new JFrame();
				popup.add(new ScreenMakeRes());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				/* vacancies will be updated when this window is completed */

			}

		});
		
		done.addActionListener(new ActionListener() {

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
		buttons.add(confirm);
		buttons.add(moreReservations)
		buttons.add(back);
		buttons.add(done);
		
		add(vacancies);
		add(buttons);
	}

	/**
	 * Gets vacant rooms that match the price and reservation dates
	 * @return String of vacant rooms 
	 */
	public String printRooms() {
		return "look at all these rooms";
	}
}
