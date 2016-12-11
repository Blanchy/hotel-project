// import sun.tools.tree.GreaterOrEqualExpression;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 **/
public class Reservation {
	private int roomIndex;
    private String userID;
    private String startDate; //in format MM//DD/YYYY
    private String endDate; //in format MM/DD/YYYY
    private Calendar startCal;
    private Calendar endCal;


    /**
     * Creates a new Reservation.
     * @param roomIndex room index to which the reservation belongs to
     * @param userID userID of the person reserving the room
     * @param startDate start date of the reservation in format: MM/DD/YYYY
     * @param endDate end date of the reservation in format: MM/DD/YYYY
     */
    public Reservation(int roomIndex, String userID, String startDate, String endDate)
    {
        this.userID = userID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomIndex = roomIndex;

        String[] startDateArray = startDate.split("/");
        int startDateMonth = Integer.parseInt(startDateArray[0]);
        int startDateDay = Integer.parseInt(startDateArray[1]);
        int startDateYear = Integer.parseInt(startDateArray[2]);

        String[] endDateArray = endDate.split("/");
        int endDateMonth = Integer.parseInt(endDateArray[0]);
        int endDateDay = Integer.parseInt(endDateArray[1]);
        int endDateYear = Integer.parseInt(endDateArray[2]);

        startCal = new GregorianCalendar(startDateYear, startDateMonth-1, startDateDay);
        endCal = new GregorianCalendar(endDateYear, endDateMonth-1, endDateDay);

    }

    /**
     * gets date of start of reservation
     * @return Date of the start of reservation
     */
    public Date getStartCal() {return startCal.getTime();}

    /**
     * gets date of end of reservation
     * @return Date of end of reservations
     */
    public Date getEndCal() {return endCal.getTime();}

    /**
     * Checks if a date is available.
     * tldr; checks if a date is in between the start and end dates
     * @param isAvaliableDate date to be checked in format MM/DD/YYYY
     * @return false if isAvailableDate is in between the start and end date,
     * true otherwise
     */
    public boolean isResAvailable(String isAvaliableDate)
    {
        //System.out.println("ENTER RESERVATION DEBUG MODE");
        String[] checkDateArray = isAvaliableDate.split("/");
        int checkDateMonth = Integer.parseInt(checkDateArray[0]);
        int checkDateDay = Integer.parseInt(checkDateArray[1]);
        int checkDateYear = Integer.parseInt(checkDateArray[2]);
        Calendar tempCalendar = new GregorianCalendar(checkDateYear, checkDateMonth-1, checkDateDay);
        Date checkDate = tempCalendar.getTime();
        //System.out.println("checkDate: " + checkDate);
        Date startDate = startCal.getTime();
        //System.out.println("startDate: " + startDate);
        Date endDate = endCal.getTime();
        //System.out.println("endDate: " + endDate);

        return (checkDate.before(startDate) || checkDate.after(endDate));
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
     * @return the number of days in between startDate and endDate
     */
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

    /**
     * @return String representation of the reservation in format
     * "USERID has reserved from STARTDATE to ENDDATE. Length of stay: LENGTHOFSTAY."
     */
    public String toString()
    {
        String rtn = userID + " has reserved from " + startDate + " to " + endDate +
        ". Length of stay: " + getNumberOfDays(startDate, endDate);
        return rtn; 
    }
}
