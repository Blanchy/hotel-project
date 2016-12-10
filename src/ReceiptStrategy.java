/**
 * Created by chrisnavy on 11/24/16.
 */
public interface ReceiptStrategy {

    //userID
    //name
    //reservedRooms
    //corresponding total amount

    public void printReceipt();

    public void getUserID();

    public void getName();

    public void getRooms();

    public void getTotalDues();
}
