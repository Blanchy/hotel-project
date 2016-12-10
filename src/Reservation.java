// import sun.tools.tree.GreaterOrEqualExpression;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by JonWong on 11/5/16.
 */
public class Reservation {
	private int roomIndex;
    private String userID;
    private String startDate; //in format MM//DD/YYYY
    private String endDate; //in format MM/DD/YYYY
    private Calendar cal1 = new GregorianCalendar();
    private Calendar cal2 = new GregorianCalendar();


    /**
     * Creates a new Reservation.
     * If length of stay exceeds 60 days, userID is -1, startDate/endDate = null.
     * @param userID userID of the person reserving the room
     * @param startDate start date of the reservation
     * @param endDate end date of the reservation
     */
    public Reservation(int arrayIndex, String userID, String startDate, String endDate)
    {
        /*
        if (getNumberOfDays(startDate, endDate) > 60)
        {
            this.userID = "invalid userID";
            this.startDate = "invalid startDate";
            this.endDate = "invalid endDate";
            System.out.println("INVALID RESERVATION: LENGTH OF STAY TOO LONG.");
        }
        else
        {
            this.userID = userID;
            this.startDate = startDate;
            this.endDate = endDate;
        }
        */

            this.userID = userID;
            this.startDate = startDate;
            this.endDate = endDate;
            roomIndex = arrayIndex;

        String[] startDateArray = startDate.split("/");
        int startDateMonth = Integer.parseInt(startDateArray[0]);
        int startDateDay = Integer.parseInt(startDateArray[1]);
        int startDateYear = Integer.parseInt(startDateArray[2]);

        String[] endDateArray = endDate.split("/");
        int endDateMonth = Integer.parseInt(endDateArray[0]);
        int endDateDay = Integer.parseInt(endDateArray[1]);
        int endDateYear = Integer.parseInt(endDateArray[2]);

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        cal1.set(startDateYear, startDateMonth+1, startDateDay);
        cal2.set(endDateYear, endDateMonth+1, endDateDay);

    }

    public boolean isAvailable(String isAvaliableDate) //format MM/DD/YYYY
    {
        String[] checkDateArray = isAvaliableDate.split("/");
        int checkDateMonth = Integer.parseInt(checkDateArray[0]);
        int checkDateDay = Integer.parseInt(checkDateArray[1]);
        int checkDateYear = Integer.parseInt(checkDateArray[2]);
        Calendar tempCalendar = new GregorianCalendar(checkDateYear, checkDateMonth+1, checkDateDay);
        Date checkDate = tempCalendar.getTime();

        Date startDate = cal1.getTime();
        Date endDate = cal2.getTime();

        return !(checkDate.before(startDate) || checkDate.after(endDate));
    }

    /**
     * gets the userID of the person who made the reservation
     * @return userID of the reservation
     */
    public String getUserID() {return userID;}

    /**
     * gets starting date of the reservation
     * @return starting date of reservation
     */
    public String getStartDate() {return startDate;}
    
    /**
     * gets ending date of the reservation
     * @return ending date of reservation
     */
    public String getEndDate() {return endDate;}
    
    /**
     * returns array index within which Reservation object occupies Room[]
     * @return room index as it is in array
     */
    public int getRoomIndex() { return roomIndex; }

    /**
     * Returns the numbers of the days in between the startDate and endDate, not including the endDate.
     * Length of stay cannot be longer than 60 days.
     * @return the number of days in between startDate and endDate, or -1 if
     *         reservation is longer than 60 days.
     */
    //get number of days in between the startDate and endDate, not including endDate.
    public int getNumberOfDays(String startDate, String endDate)
    {
    	String[] sd = startDate.split("/");
    	String[] ed = endDate.split("/");
    	
    	Calendar tempCal1 = new GregorianCalendar(Integer.parseInt(sd[2]), 
    			Integer.parseInt(sd[0]) + 1, Integer.parseInt(sd[1]));
    	Calendar tempCal2 = new GregorianCalendar(Integer.parseInt(ed[2]), 
    			Integer.parseInt(ed[0]) + 1, Integer.parseInt(ed[1]));
        int daysBetween = (int) ((tempCal2.getTime().getTime() - tempCal1.getTime().getTime()) / (1000 * 60 * 60 * 24));
        /*if (daysBetween > 60) {daysBetween = -1;}*/
        return daysBetween;
    }

    public String toString()
    {
        String rtn = userID + "has reserved from " + startDate + " to " + endDate +
        ". Length of stay: " + getNumberOfDays(startDate, endDate);
        return rtn; 
    }
} //test comment 
