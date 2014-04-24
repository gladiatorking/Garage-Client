
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fokken
 */
public class ParkingSession {
    private int spot;
    private Calendar starttime;
    private Calendar finishtime;
    private String user;
    
    public ParkingSession(int newSpot, String newusername)
    {
        spot = newSpot;
        starttime = Calendar.getInstance();
        
        user = newusername;
    }
    /**
     * write start and finish time as values 1-24
     * @param newSpot
     * @param newstarttime
     * @param newfinishtime 
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
    public void setUser(String name)
    {
        user= name;
    }
    public String getUser()
    {
        return user;
    }
    public void setSpot(int newspot)
    {
        spot = newspot;
    }
    public int getSpot()
    {
        return spot;
    }
    public void setStartingtime(Calendar newStarttime)
    {
        starttime= newStarttime;
    }
    public void setFinishtime(Calendar newfinishtime)
    {
        finishtime= newfinishtime;
    }
    public Calendar getStartingtime()
    {
        return starttime;
    }
    public Calendar getFinishtime()
    {
        return finishtime;
    }
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
    @Override
    public String toString()
    {
        String result = "";
        result = "User:" + user + "Spot: " + spot + " the start time is: "+ starttime.toString()
                + " the finish time: "+ finishtime.toString();
        return result;
    }
}
