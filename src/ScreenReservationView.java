/**
 * Created by chrisnavy on 12/8/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Formats the reservations of a particular guest to display
 * on the GUI.
 **/


public class ScreenReservationView extends JPanel{

	/**
	 * Constructor for classes of this object
	 * @param rn room number
	 * @param dt dates
	 */
    ScreenReservationView(String rn, String dt){
        setLayout(new GridLayout(0,1));

        add(new JLabel("Room Number: " + rn));
        add(new JLabel("Dates: " + dt));

    }


}

