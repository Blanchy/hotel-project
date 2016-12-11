/**
 * Created by chrisnavy on 11/24/16.
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Simple Receipt Format that implements the Receipt Strategy
 */
public class SimpleReceipt implements ReceiptStrategy {
    private JFrame receiptFrame;
    private JPanel namePanel;
    private JPanel userIDPanel;
    private JPanel reservedRoomsPanel;
    private JPanel totalDuesPanel;

    private int totalDue;
    String name;
    private ArrayList<Reservation> rooms;
    private ArrayList<Integer> reserved;
    String userID;

    /**
     * Constructor for printing the receipt in Simple Format
     * @param info
     */
    SimpleReceipt(ArrayList info){


        receiptFrame = new JFrame("Simple Receipt");

        namePanel = new JPanel();
        userIDPanel = new JPanel();
        reservedRoomsPanel = new JPanel();
        totalDuesPanel = new JPanel();

        reservedRoomsPanel.setLayout(new GridLayout(0,1));


        JTextArea userID = new JTextArea(info.get(0).toString());
        userID.setEditable(false);

        userIDPanel.add(userID);

        reservedRoomsPanel.add(new JLabel("Rooms that are going to be Reserved: "));


        reserved = (ArrayList<Integer>) info.get(2);
        rooms = (ArrayList<Reservation>) info.get(1);

        /**
         * Prints individual rooms reserved.
         */
        for(int i = 0; i < reserved.size(); i++){
            JTextArea rm = new JTextArea(Integer.toString(reserved.get(i) + 1)  + ": " + rooms.get(i).toString() );
            rm.setEditable(false);
            reservedRoomsPanel.add(rm);
        }

        totalDuesPanel.add(new JLabel("Total Dues: "));
        this.getTotalDues();
        totalDuesPanel.add(new JLabel("$" + Integer.toString(totalDue)));
        this.printReceipt();


    }


    @Override
    /**
     * displays receipt information in a new window.
     */
    public void printReceipt() {
        receiptFrame.setLayout(new BoxLayout(receiptFrame.getContentPane(), BoxLayout.Y_AXIS));

        receiptFrame.add(namePanel);
        receiptFrame.add(userIDPanel);
        receiptFrame.add(reservedRoomsPanel);
        receiptFrame.add(totalDuesPanel);

        receiptFrame.pack();
        receiptFrame.setVisible(true);
    }

    @Override
    /**
     * calculates total dues cost.
     */
    public void getTotalDues() {
        for(int i = 0; i < reserved.size(); i++){
            int temp = reserved.get(i);
            if(temp >= 10){
                int add = 80 * rooms.get(i).getNumberOfDays(rooms.get(i).getStartDate(), rooms.get(i).getEndDate());

                totalDue += add;
            } else if(temp < 10){
                int add = 200 * rooms.get(i).getNumberOfDays(rooms.get(i).getStartDate(), rooms.get(i).getEndDate());

                totalDue += add;
            }
        }
    }


}
