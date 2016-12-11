import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 **/
public class ScreenMakeRes extends JPanel {

	private HotelView view;
	private boolean popup; /* if ScreenMakeRes was created by
	 						  on ScreenVacancies then it is a
	 						  popup that closes when the buttons
	 						  are pressed and leads ScreenVacancies
	 						  to update */
	private GuestSession gs;

	public ScreenMakeRes(HotelView v, boolean pp) {
		popup = pp;
		view = v;
		gs = (GuestSession) view.getUserSession();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Dimension tf = new Dimension(200,25);
		
		JLabel instructions = new JLabel("Note: Reservations may not exceed 60 days");
		
		JLabel checkIn = new JLabel("Check in (MM/DD/YYYY):");
		JTextField checkInDate = new JTextField();
		checkInDate.setPreferredSize(tf);
		
		JLabel checkOut = new JLabel("Check out (MM/DD/YYYY):");
		JTextField checkOutDate = new JTextField();
		checkOutDate.setPreferredSize(tf);
		
		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new FlowLayout());
		
		JButton seeLuxuryRooms = new JButton("See Luxury Rooms");	
		JButton seeEconomicRooms = new JButton("See Economic Rooms");
		
		seeLuxuryRooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkSyntax(checkInDate.getText(),checkOutDate.getText())) {
					gs.setPrice(200);
					gs.setDates(checkInDate.getText(),checkOutDate.getText());

					if (popup) { /*if popup, then it just closes */
						((JFrame) (((JComponent) e.getSource()).getTopLevelAncestor())).dispose(); 
					}
					else {
						gs.eraseNewReservations();
						view.changeScreen(new ScreenVacancies(view));
					}
				}
			}

		});
		
		seeEconomicRooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkSyntax(checkInDate.getText(),checkOutDate.getText())) {
					gs.setPrice(80);
					gs.setDates(checkInDate.getText(),checkOutDate.getText());

					if (popup) { /*if popup, then it just closes */
						((JFrame) (((JComponent) e.getSource()).getTopLevelAncestor())).dispose(); 
					}
					else {
						gs.eraseNewReservations();
						view.changeScreen(new ScreenVacancies(view));
					}
				}
			}

		});
		
		add(instructions);
		add(checkIn);
		add(checkInDate);
		add(checkOut);
		add(checkOutDate);
		
		buttonPan.add(seeLuxuryRooms);
		buttonPan.add(seeEconomicRooms);
		add(buttonPan);
	}
	
	public boolean checkSyntax(String input1, String input2) {
		try {
			String[] array1 = input1.split("/");
			String[] array2 = input2.split("/");
			for (String s : array1) {
				int x = Integer.parseInt(s);
			}
			for (String s : array2) {
				int x = Integer.parseInt(s);
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input!", "Error", 
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		Reservation test = new Reservation(-1, "", input1, input2);
		if (test.getNumberOfDays(input1, input2) > 60) {
			JOptionPane.showMessageDialog(null, "Reservations can't be longer than 60 days.", "Error", 
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(test.getNumberOfDays(input1, input2));
			return false;
		}
		else if (test.getNumberOfDays(input1, input2) <= 0) {
			JOptionPane.showMessageDialog(null, "The check-out date is earlier than the check-in date.", "Error", 
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(test.getNumberOfDays(input1, input2));
			return false;
		}
		return true;
	}

}
