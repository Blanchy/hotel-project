import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ScreenVacancies extends JPanel {

	private HotelView view; 
	private ChangeListener listener;
	private GuestSession gs;
	
	public ScreenVacancies(HotelView v) {
		view = v;
		gs = (GuestSession) view.getUserSession();
		setLayout(new FlowLayout());
		
		JPanel vacancies = new JPanel();
		
		vacancies.setLayout(new FlowLayout());
		JTextArea rooms = new JTextArea(); 
		rooms.setPreferredSize(new Dimension(200, 400));
		rooms.setText(printRooms(gs.getRooms()));
		rooms.setEditable(false);
		
		JScrollPane scrollRooms = new JScrollPane(rooms, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				ArrayList<Room> vacants = gs.getRooms(); /*gets available rooms*/
				rooms.setText(printRooms(vacants));
				rooms.repaint();
				vacancies.repaint();
				repaint();
			}
		};
		gs.attach(listener);
		
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		JLabel enterPrompt = new JLabel("Enter room number:");
		JTextField enterRoom = new JTextField();
		JButton confirm = new JButton("Confirm");
		JButton	moreReservations = new JButton("More reservations?");
		JButton done = new JButton("Done");
		
		confirm.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				/*
				 * gs.addReservation
				 */
			}

		});
		
		/*
		 * pops-up screen to choose start/end dates and price
		 */
		moreReservations.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame popup = new JFrame();
				popup.add(new ScreenMakeRes(view, true));
				popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				popup.pack();
				popup.setVisible(true);
				/* vacancies will be updated when this window is completed */
			}
		});
		
		/*
		 * updates Hotel with the new reservations
		 */
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Reservation> newRes = ((GuestSession) view.getUserSession()).getNewReservations();
				for (Reservation r : newRes) {
					view.getHotel().addReservation(r);
				}
				view.changeScreen(new ScreenReceiptOptions(view));
			}
		});
		

		vacancies.add(scrollRooms);
		
		buttons.add(enterPrompt);
		buttons.add(enterRoom);
		buttons.add(confirm);
		buttons.add(moreReservations);
		buttons.add(done);
		
		add(vacancies);
		add(buttons);
		
	}

	/**
	 * Gets vacant rooms that match the price and reservation dates
	 * @return String of vacant rooms 
	 */
	public String printRooms(ArrayList<Room> vacants) {
		String text = "Rooms for " + gs.getStart() + " - " + gs.getEnd() + "\n\n";
		if (vacants.size() > 0) {
			for (Room r : vacants) {
				text = text + r.getRoomNumber() + "\n";
			}
		}
		return text;
	}
}
