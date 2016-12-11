/**
 * Created by chrisnavy on 12/8/16.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;


public class ScreenReservations extends JPanel{

	HotelView view;
	private GuestSession gs;

	ScreenReservations(HotelView v){

		view = v;
		gs = (GuestSession) view.getUserSession();

		/**
		 * get reservations here!
		 */
		//getReservations();

		JButton menu = new JButton("Return to Guest Menu");

		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenGuestOptions(view));

			}

		});

		ArrayList<Reservation> rooms = ((GuestSession) view.getUserSession()).getAllReservations();

		setLayout(new GridLayout(0,1));
        
        if(rooms.size() == 0){
            JPanel temp = new ScreenReservationView("No Rooms Reserved", "No Dates Reserved");
            add(temp);
            add(menu);
        }

		for(int i = 0; i < rooms.size(); i++) {
			JPanel temp = new ScreenReservationView(Integer.toString(rooms.get(i).getRoomIndex() + 1),rooms.get(i).getStartDate() + "-" + rooms.get(i).getEndDate());
        final int numberHolder = i;


			temp.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {

					Object[] options = {"no",
							"yes"};
					int op = JOptionPane.showOptionDialog(null,
							"Are you sure you want to cancel this reservation?",
							"Confirm Cancellation",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[1]);

					if(op == JOptionPane.NO_OPTION){
						/**
						 * Delete Reservation here
						 */
						view.getHotel().deleteReservation(rooms.get(numberHolder).getRoomIndex(),rooms.get(numberHolder).getStartDate());
						temp.setVisible(false);
					}


				}

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}
			});


			add(temp);
			add(menu);
		}
	}

	public void getReservations(String id){
		/**
		 * Function for getting reservations for a particular
		 */
		//view.getHotel().getRooms();
	}



}
