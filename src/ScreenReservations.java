/**
 * Created by chrisnavy on 12/8/16.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class ScreenReservations extends JPanel{

	HotelView view;

	ScreenReservations(HotelView v){

		view = v;

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

		String[][] rooms = new String[5][2];

		for(int i = 0; i < 5; i++){
			rooms[i][0] = "10/28/2016";
			rooms[i][1] = "L" + i;
		}


		//Add the ubiquitous "Hello World" label.
		setLayout(new GridLayout(0,1));

		for(int i = 0; i < rooms.length; i++) {
			JPanel temp = new ScreenReservationView(rooms[i][0],rooms[i][1]);

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
						//view.getHotel().deleteReservation();
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
