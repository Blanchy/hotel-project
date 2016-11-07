import java.util.ArrayList;

/**
 * Created by JonWong on 11/5/16.
 */
public class Room {
    boolean isReserved;
    private int price; //price of room
    private int number; //room number
    private ArrayList<Reservation> reservations;

    public Room(int number, int price)
    {
        this.number = number;
        this.price = price;
    }


    public int getPrice() {return this.price;}
    public int getRoomNumber() {return this.number;}


    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }



    public void deleteReservation(String userID, String startDate)
    {
        for (int i = 0; i < reservations.size(); i++)
        {
            Reservation r = reservations.get(i);
            if ((r.getUserID().equals(userID)) && (r.getStartDate().equals(startDate)))
            {
                reservations.remove(i);
                return;
            }
        }
        System.out.println("Reservation doesn't exist.");
        return;
    }

    public String toString()
    {
        String rtn = "Room: " + this.number + " has following reservations: \n";
        if (reservations.isEmpty())
        {
            rtn += "NO RESERVATIONS.";
        }
        else {
            for (Reservation r : reservations) {
                rtn += r.toString() + "\n";
            }
        }
        return rtn;
    }
}
