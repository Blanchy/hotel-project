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
        reservations = new ArrayList<Reservation>();
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

    /**
     * Checks dates for availability. Assumes dates are in format MM/DD/YYYY
     * @param date1 the start date in MM/DD/YYYY
     * @param date2 the end date in MM/DD/YYYY
     * @return if room is available between these dates
     */
    public boolean isAvailable(String date1, String date2) {
    	String[] dateArray1 = date1.split("/");
    	String[] dateArray2 = date2.split("/");
    	
    	Calendar start = new GregorianCalendar(Integer.parseInt(dateArray1[1]), 
    			Integer.parseInt(dateArray1[0]) + 1, Integer.parseInt(dateArray1[2]));
    	start.clear(Calendar.HOUR); start.clear(Calendar.MINUTE); start.clear(Calendar.SECOND);start.clear(Calendar.MILLISECOND);
    	
    	Calendar end = new GregorianCalendar(Integer.parseInt(dateArray2[1]), 
    			Integer.parseInt(dateArray2[0]) + 1, Integer.parseInt(dateArray2[2]));
    	end.clear(Calendar.HOUR); end.clear(Calendar.MINUTE); end.clear(Calendar.SECOND);end.clear(Calendar.MILLISECOND);
    	
    	while (!start.equals(end)) {
    		String testDate = start.get(Calendar.MONTH) + "/" + 
    				start.get(Calendar.DATE) + "/" + start.get(Calendar.YEAR);
    		if (!isAvailable(testDate)) { 			
    			return false;
    		}
    		start.add(Calendar.DATE, 1);
    	}
    	
    	return true;
    }
    
    public ArrayList<Reservation> getAllReservations()
    {
        return reservations;
    }


    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }

    public void deleteReservation(/*String userID,*/ String startDate) //maybe delete userID? because multiple users can't have the same start date
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
