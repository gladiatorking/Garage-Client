
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
    private Calendar currenttime;
    private int spot;
    private long starttime;
    private long finishtime;
    private String user;
    
    public ParkingSession(int newSpot, String newusername)
    {
        spot = newSpot;
        currenttime = Calendar.getInstance();
        starttime =  currenttime.getTimeInMillis();
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
        Calendar temp = Calendar.getInstance();
        Calendar temp1 = Calendar.getInstance();
        temp.set(year, month, day, newstarttime, 0);
        temp1.set(year , month, day, newfinishtime , 0);
        starttime = temp.getTimeInMillis();
        finishtime = temp1.getTimeInMillis();
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
    public void setStartingtime(int newStarttime)
    {
        starttime= newStarttime;
    }
    public void setFinishtime(int newfinishtime)
    {
        finishtime= newfinishtime;
    }
    public long getStartingtime()
    {
        return starttime;
    }
    public long getFinishtime()
    {
        return finishtime;
    }
    public int checkout()
    {
        currenttime = Calendar.getInstance();
        finishtime = currenttime.getTimeInMillis();
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
        long total = (finishtime - starttime) * (1/3600000);
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
        result = "Spot: " + spot + " the start time is: "+ starttime + " the finish time: "+ finishtime;
        return result;
    }
}
