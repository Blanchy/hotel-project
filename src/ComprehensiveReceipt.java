/**
 * Created by chrisnavy on 11/24/16.
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ComprehensiveReceipt implements ReceiptStrategy {
    private JFrame receiptFrame;
    private JPanel namePanel;
    private JPanel userIDPanel;
    private JPanel reservedRoomsPanel;
    private JPanel totalDuesPanel;

    private int totalDue;
    private ArrayList<Reservation> rooms;
    private ArrayList<Integer> reserved;

    /**
     * Creates a new Comprehensive Receipt
     * @param info information to be displayed on the receipt
     */
    ComprehensiveReceipt(ArrayList info){

        this.getRooms();

        receiptFrame = new JFrame("Simple Receipt");

        namePanel = new JPanel();
        userIDPanel = new JPanel();
        reservedRoomsPanel = new JPanel();
        totalDuesPanel = new JPanel();

        reservedRoomsPanel.setLayout(new GridLayout(0,1));


        userIDPanel.add(new JLabel("User ID: "));

        JTextArea userID = new JTextArea(info.get(0).toString());
        userID.setEditable(false);

        userIDPanel.add(userID);

        reservedRoomsPanel.add(new JLabel("Rooms reserved: "));


        reserved = (ArrayList<Integer>) info.get(2);
        rooms = (ArrayList<Reservation>) info.get(1);

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

    /**
     * Pop ups receipt of all the reservations.
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
    public void getUserID() {

    }

    @Override
    public void getName() {

    }

    @Override
    public void getRooms() {

    }

    /**
     * Updates the total price in field 'totalDue'
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
