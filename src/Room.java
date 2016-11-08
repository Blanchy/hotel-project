import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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


    public boolean isAvailable(String isAvaliableDate)
    {
        String[] checkDateArray = isAvaliableDate.split("/");
        int checkDateMonth = Integer.parseInt(checkDateArray[0]);
        int checkDateDay = Integer.parseInt(checkDateArray[1]);
        int checkDateYear = Integer.parseInt(checkDateArray[2]);
        Calendar tempCalendar = new GregorianCalendar(checkDateYear, checkDateMonth+1, checkDateDay);
        Date checkDate = tempCalendar.getTime();


        boolean flag = true;
        for (Reservation r : reservations)
        {
            flag = r.isAvailable(isAvaliableDate);
            if (flag == false)
            {return flag;} //if flag is every false,
        }
        return flag;
    }

    public ArrayList<Reservation> getAllReservations()
    {
        return reservations;
    }


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

    public void deleteAllReservation()
    {
        reservations.clear();
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
