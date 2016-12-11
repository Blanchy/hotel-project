/**
 * Created by chrisnavy on 12/8/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View Reservation JPanel for User Reservations.
 */
public class ScreenReservationView extends JPanel{

    /**
     * creates a Panel that shows Reservation information.
     * @param rn Room Number of the Room
     * @param dt Dates that the room is booked.
     */
    ScreenReservationView(String rn, String dt){
        setLayout(new GridLayout(0,1));

        setPreferredSize(new Dimension(400,200));

        add(new JLabel("Room Number: " + rn));
        add(new JLabel("Dates: " + dt));

    }


}

