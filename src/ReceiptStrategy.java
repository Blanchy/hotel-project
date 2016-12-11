/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
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
