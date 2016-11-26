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
    private ArrayList<String> rooms;
    String userID;

    ComprehensiveReceipt(){

        this.getRooms();

        receiptFrame = new JFrame("Comprehensive Receipt");
        receiptFrame.setSize(400,400);

        namePanel = new JPanel();
        userIDPanel = new JPanel();
        reservedRoomsPanel = new JPanel();
        totalDuesPanel = new JPanel();

        this.getName();
        namePanel.add(new JLabel("Name: "));
        namePanel.add(new JTextArea(name));

        this.getUserID();
        userIDPanel.add(new JLabel("User ID: "));
        userIDPanel.add(new JTextArea(userID));

        reservedRoomsPanel.add(new JLabel("Rooms that are going to be Reserved: "));
        reservedRoomsPanel.add(new JTextArea(rooms.toString()));

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
        rooms = new ArrayList<>();

        rooms.add("E8");
        rooms.add("L4");
        rooms.add("E2");
        rooms.add("L5");
        rooms.add("L9");
        rooms.add("E1");
    }

    @Override
    public void getTotalDues() {
        for(int i = 0; i < rooms.size(); i++){
            String temp = Character.toString(rooms.get(i).charAt(0));
            if(temp.equals("E")){
                totalDue += 80;
            } else if(temp.equals("L")){
                totalDue += 200;
            }
        }
    }



}
