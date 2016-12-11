import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 **/
public class Room {
    private int price; //price of room
    private int number; //room number
    private ArrayList<Reservation> reservations;

    /**
     * Creates a new room.
     * Rooms 1-10 (indexes 0-9) are luxury, and 11-19 (indexes 10-19) are economy.
     * Luxury: $200
     * Economy: $80
     * @param number Assigned room number.
     * @param price the price associated with the respective room.
     */
    public Room(int number, int price)
    {
        this.number = number;
        this.price = price;
        reservations = new ArrayList<Reservation>();
    }

    /**
     * @return returns the price of the room.
     */
    public int getPrice() {return this.price;}

    /**
     * @return returns the room number.
     */
    public int getRoomNumber() {return this.number;}

    /**
     * Checks if the room is available on a certain date
     * @param isAvaliableDate the date to be checked in format MM/DD/YYYY
     * @return true if the room is available on the date,
     * false otherwise
     */
    public boolean isRoomAvailable(String isAvaliableDate)
    {
        //System.out.println("ENTER ROOM DEBUG MODE");
        //System.out.println("isAvaliableDate: " + isAvaliableDate + " lmao why did i decide to print this");
        String[] checkDateArray = isAvaliableDate.split("/");
        int checkDateMonth = Integer.parseInt(checkDateArray[0]);
        int checkDateDay = Integer.parseInt(checkDateArray[1]);
        int checkDateYear = Integer.parseInt(checkDateArray[2]);
        Calendar tempCalendar = new GregorianCalendar(checkDateYear, checkDateMonth-1, checkDateDay);
        //System.out.println("tempcalendar time: " + tempCalendar.getTime());
        Date checkDate = tempCalendar.getTime();

        boolean flag = true;
        for (Reservation r : reservations)
        {
            flag = r.isResAvailable(isAvaliableDate);
            if (flag == false)
            {return flag;} //if flag is every false,
        }
        return flag;
    }

    /**
     * Checks dates for availability. Assumes dates are in format MM/DD/YYYY
     * @param date1 the start date in format MM/DD/YYYY
     * @param date2 the end date in format MM/DD/YYYY
     * @return true if room is available between these dates, false otherwise
     */
    public boolean isRoomAvailable(String date1, String date2) {
    	String[] dateArray1 = date1.split("/");
    	String[] dateArray2 = date2.split("/");
    	
    	Calendar start = new GregorianCalendar(Integer.parseInt(dateArray1[2]), 
    			Integer.parseInt(dateArray1[0])-1, Integer.parseInt(dateArray1[1]));
    	start.clear(Calendar.HOUR);
        start.clear(Calendar.MINUTE);
        start.clear(Calendar.SECOND);
        start.clear(Calendar.MILLISECOND);
        //System.out.println("start cal: " + start.getTime());
    	Calendar end = new GregorianCalendar(Integer.parseInt(dateArray2[2]), 
    			Integer.parseInt(dateArray2[0])-1, Integer.parseInt(dateArray2[1]));
        //System.out.println("end cal: " + end.getTime());
    	end.clear(Calendar.HOUR);
        end.clear(Calendar.MINUTE);
        end.clear(Calendar.SECOND);
       end.clear(Calendar.MILLISECOND);


    	while (!start.equals(end)) {
    		String testDate = start.get(Calendar.MONTH)+1 + "/" +
    				start.get(Calendar.DATE) + "/" + start.get(Calendar.YEAR);
            //System.out.println("TEST DATE IS: " + testDate);
    		if (!isRoomAvailable(testDate)) {
    			return false;
    		}
    		start.add(Calendar.DATE, 1);
    	}
    	
    	return true;
    }

    /**
     * @return Returns an arraylist of type Reservation of all the reservations for the room.
     */
    public ArrayList<Reservation> getAllReservations()
    {
        return reservations;
    }

    /**
     * @param r reservation to be added to the room.
     */
    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }

    /**
     * Deletes the room reservation based on the start date.
     * @param startDate start date of the reservation to be deleted.
     */
    public void deleteReservation(/*String userID,*/ String startDate)
    //maybe delete userID? because multiple users can't have the same start date
    {
        for (int i = 0; i < reservations.size(); i++)
        {
            Reservation r = reservations.get(i);
            if ((r.getStartDate().equals(startDate)))
            {
                reservations.remove(i);
                return;
            }
        }
        System.out.println("Reservation doesn't exist.");
        return;
    }

    /**
     * Deletes all reservations for the room.
     */
    public void deleteAllReservation()
    {
        reservations.clear();
    }

    /**
     * @return String representation of the reservations in the room.
     */
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
