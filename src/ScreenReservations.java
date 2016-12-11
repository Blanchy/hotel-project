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


/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 * 
 * JPanel which shows all reservations of the current Guest.
 *
 **/
public class ScreenReservations extends JPanel{

	HotelView view;
	private GuestSession gs;

	/**
	 * Constructor for classes of this object.
	 * @param v HotelView object upon which this JPanel is mounted.
	 */
	ScreenReservations(HotelView v){

		view = v;
		gs = (GuestSession) view.getUserSession();


/**
 * returns user to Guest Menu
 */
        JButton menu = new JButton("Return to Guest Menu");

		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenGuestOptions(view));

			}

		});

		ArrayList<Reservation> rooms = ((GuestSession) view.getUserSession()).getAllReservations();

		setLayout(new GridLayout(0,1));


        /**
         * Default case if no rooms are reserved.
         */
        if(rooms.size() == 0){
            JPanel temp = new ScreenReservationView("No Rooms Reserved", "No Dates Reserved");
            add(temp);
            add(menu);
        }

        /**
         * creates JPanels for every screen reservation by the user.
         * Clickable and clicking it will prompt user to delete the reservation or not.
         */
		for(int i = 0; i < rooms.size(); i++) {
			JPanel temp = new ScreenReservationView(Integer.toString(rooms.get(i).getRoomIndex() + 1),rooms.get(i).getStartDate() + "-" + rooms.get(i).getEndDate());
        final int numberHolder = i;


            /**
             * Mouse Listener for clicking.
             */
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
						System.out.println(rooms.get(numberHolder).getRoomIndex());
                        System.out.println(rooms.get(numberHolder).getStartDate());
						view.getHotel().deleteReservation(rooms.get(numberHolder).getRoomIndex(),rooms.get(numberHolder).getStartDate());
                        gs.deleteReservation(rooms.get(numberHolder).getRoomIndex(),rooms.get(numberHolder).getStartDate());
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
