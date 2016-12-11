/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Interface to format reciept using Strategy method.
 **/
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
