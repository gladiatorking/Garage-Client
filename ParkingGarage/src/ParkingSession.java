
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fokken
 */
public class ParkingSession implements Serializable{
    private int spot;
    private Calendar starttime;
    private Calendar finishtime;
    private String user;
    /**
     * Constructor for parkingSession for temporary user!
     * pass in string of user or license plate
     * @param newSpot
     * @param newusername 
     */
    public ParkingSession(int newSpot, String newusername)
    {
        spot = newSpot;
        starttime = Calendar.getInstance();
        
        user = newusername;
    }
    /**
     * write start and finish time as values 1-24
     * Constructor for reservation
     * @param newSpot
     * @param newstarttime
     * @param newfinishtime
     * @param month
     * @param day
     * @param year
     * @param username 
     */
    public ParkingSession(int newSpot,int newstarttime, int newfinishtime, int month, int day, int year, String username)
    {
        spot = newSpot;
        starttime = Calendar.getInstance();
        finishtime = Calendar.getInstance();
        starttime.set(year, month, day, newstarttime, 0);
        finishtime.set(year , month, day, newfinishtime , 0);
        user = username;
    }
    /**
     * mutator for name
     * @param name 
     */
    public void setUser(String name)
    {
        user= name;
    }
    /**
     * accessor for user
     * @return user
     */
    public String getUser()
    {
        return user;
    }
    /**
     * mutator for newspot
     * @param newspot 
     */
    public void setSpot(int newspot)
    {
        spot = newspot;
    }
    /**
     * accessor for spot
     * @return spot
     */
    public int getSpot()
    {
        return spot;
    }
    /**
     * mutator for newStarttime
     * @param newStarttime 
     */
    public void setStartingtime(Calendar newStarttime)
    {
        starttime= newStarttime;
    }
    /**
     * mutator for newFinishtime
     * @param newfinishtime 
     */
    public void setFinishtime(Calendar newfinishtime)
    {
        finishtime= newfinishtime;
    }
    /**
     * accessor for startime
     * @return starttime
     */
    public Calendar getStartingtime()
    {
        return starttime;
    }
    /**
     * accessor for finishtime
     * @return finishtime
     */
    public Calendar getFinishtime()
    {
        return finishtime;
    }
    /**
     * sets the finishtime to when you call the function
     * then calls the function getHours
     * @return hours
     */
    public int checkout()
    {
        finishtime = Calendar.getInstance();
        return getHours();
    }
    /**
     * finds the difference in hours.
     * rounds down after 1 hour
     * otherwise will always pay at least 1 hour.
     * @return total
     */
    public int getHours()
    {
        long total = (finishtime.getTimeInMillis() - starttime.getTimeInMillis()) * (1/3600000);
        if(total == 0)
        {
            return 1;
        }
        else{
            return (int) total;
        }
    }
    /**
     * toStringMethod
     * @return String
     */
    @Override
    public String toString()
    {
        String result = "";
        result = "User: " + user + " Spot: " + spot + " Start time: "+ starttime.getTime().toString()
                + " End Time: "+ finishtime.getTime().toString();
        return result;
    }
}
