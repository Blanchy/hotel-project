/**
 * Created by chrisnavy on 11/24/16.
 */
import javax.swing.*;
import java.util.*;

public class ComprehensiveReceipt implements ReceiptStrategy {
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

    ComprehensiveReceipt(ArrayList info){

        this.getRooms();

        receiptFrame = new JFrame("Simple Receipt");

        namePanel = new JPanel();
        userIDPanel = new JPanel();
        reservedRoomsPanel = new JPanel();
        totalDuesPanel = new JPanel();

        userIDPanel.add(new JLabel("User ID: "));
        userIDPanel.add(new JTextArea(info.get(0).toString()));

        reservedRoomsPanel.add(new JLabel("Rooms reserved: "));


        reserved = (ArrayList<Integer>) info.get(2);
        rooms = (ArrayList<Reservation>) info.get(1);

        for(int i = 0; i < reserved.size(); i++){
            reservedRoomsPanel.add(new JTextArea(Integer.toString(reserved.get(i) + 1)  + ": " + rooms.get(i).toString() ));
        }

        totalDuesPanel.add(new JLabel("Total Dues: "));
        this.getTotalDues();
        totalDuesPanel.add(new JLabel("$" + Integer.toString(totalDue)));
        this.printReceipt();


    }

    @Override
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
        userID = "001";
    }

    @Override
    public void getName() {
        name = "Bob";
    }

    @Override
    public void getRooms() {

    }

    @Override
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
