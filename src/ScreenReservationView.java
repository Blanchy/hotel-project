/**
 * Created by chrisnavy on 12/8/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenReservationView extends JPanel{

    ScreenReservationView(String rn, String dt){
        setLayout(new GridLayout(0,1));

        add(new JLabel("Room Number: " + rn));
        add(new JLabel("Dates: " + dt));

    }


}

