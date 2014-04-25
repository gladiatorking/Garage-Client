
import java.io.Serializable;
import java.util.ArrayList;
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
public class Garage implements Serializable {
    private int maxSpots = 50;
    public ArrayList<ParkingSession> NotAvailable;
    public ArrayList<ParkingSession> Reserved;
    private String user;
    /**
     * accessor for Reserved
     * @return Reserved
     */
    
    public Garage()
    {
        NotAvailable = new ArrayList<>(maxSpots);
        Reserved = new ArrayList<>(maxSpots);
    }
    
    public ArrayList<ParkingSession> getReserved()
    {
        return Reserved;
    }
    /**
     * accessor for maxSpots
     * @return maxSpots
     */
    public int getMaxSpots()
    {
        return maxSpots;
    }
    /**
     * checks to see if the spot is available
     * @param newspot
     * @return true if  available
     */
    public boolean spotCheck(ParkingSession newspot)
    {
        for(ParkingSession a : NotAvailable)
        {
            if(a.getSpot() == newspot.getSpot())
            {
                return false;
            }
         }
        for(ParkingSession b : Reserved)
        {
            if(b.getSpot() == newspot.getSpot()&& b.getFinishtime().getTimeInMillis()> 
                    newspot.getStartingtime().getTimeInMillis()
                    && b.getStartingtime().getTimeInMillis()< newspot.getStartingtime().getTimeInMillis())
            {
                return false;
            }
        }
        return true;
        
    }
    /**
     * adds spot to not available
     * @param newspot
     * @return 
     */
    
    public boolean addCurrentSpot(ParkingSession newspot)
    {
        if(spotCheck(newspot))
        {

                NotAvailable.add( newspot);

            return true;
        }
      return false;      
    }
    /**
     * adds reservation spot
     * @param newReservation
     * @return true if it successuflly added
     */
    public boolean addReserved(ParkingSession newReservation)
    {
        for(int a = 0; a<Reserved.size(); a++)
        {
        if(Reserved.get(a).getSpot()== newReservation.getSpot() && 
                (Reserved.get(a).getStartingtime().getTimeInMillis() <  
                newReservation.getStartingtime().getTimeInMillis()) 
                && (Reserved.get(a).getFinishtime().getTimeInMillis()
                > newReservation.getFinishtime().getTimeInMillis() ))
        {
            return false;
        }  
        }
        Reserved.add( newReservation);
        return true;
    }
    /**
     * removes reservation
     * before means that it is before the reservation time.
     * @param res
     * @param before
     * @return true if successful
     */
    public boolean removeReservation(ParkingSession res,boolean before)
    {
        Calendar current = Calendar.getInstance();
        if(res.getStartingtime().getTimeInMillis()
                < ((current.getTimeInMillis() *(1/3600000))+24)&& before)
                {
                   return false;
                }
        else
        {
            Reserved.remove(res);
            return true;
        }
    }
    /**
     * takes in user string and takes the spot out of NotAvailable
     * @param user
     * @return true if successful
     */
    public boolean makeAvailable(String user)
    {
            for(ParkingSession a : NotAvailable)
		if(a.getUser().equals(user))
                {
                    NotAvailable.set(a.getSpot()-1, null );
                    return true;
                }
            return false;
    }
    /**
     * returns Array of spots that are unavailable at that time
     * @return temp
     */
    public int[] getUnavailableSpots()
    {
	    //NotAvailable
	    //Reserved
	    
	    //int[] temp = new int[maxSpots];
	    //for(int i=0; i<maxSpots; i++)
	    //{
		//    temp[i] = i;
	    //}
	    int counter1;
            int counter2;
            Calendar now = Calendar.getInstance();
            
            if(!Reserved.isEmpty() || !NotAvailable.isEmpty())
            {
                counter1 = 0;
                counter2 = 0;
                
                for(int i=0; i<Reserved.size(); i++)
                {
                     if(Reserved.get(i) != null)
                     {
                             counter1++;
                     }
                }

                
                for(int i=0; i<NotAvailable.size(); i++)
                {
                     if(NotAvailable.get(i) != null)
                     {
                             counter2++;
                     }
                }
            }
            else
            {
                counter1 = 0;
                counter2 = 0;
            }
	    
	    int counter3 = counter1 + counter2;
	    int pointer = 0;
	    
	    int[] temp = new int[counter3];
	    
	    for(int i=0; i<Reserved.size(); i++)
	    {
		 if(Reserved.get(i) != null)
		 {
			 temp[pointer++] = Reserved.get(i).getSpot();
		 }
	    }
	    
	    for(int i=0; i<NotAvailable.size(); i++)
	    {
		 if(NotAvailable.get(i) != null)
		 {
			 temp[pointer++] = NotAvailable.get(i).getSpot();
		 }
	    }
	    
	return temp; 
    }
    /**
     * returns array of spots that are available
     * @return tempavail
     */
    public int[] getAvailable()
    {
        int[] unavailable = getUnavailableSpots();
        int[] available = new int[maxSpots];
        
        for(int i = 0; i < maxSpots; i++)
        {
            available[i] = i+1;
        }
        
        for(int i = 0; i < unavailable.length; i++)
        {
            for(int j = 0; j < maxSpots; j++)
            {
                if(available[j] == unavailable[i])
                {
                    available[j] = 0;
                }
            }
        }
        
        int counter =0;
        
        for(int i=0; i<maxSpots; i++)
        {
            if(available[i] != 0)
            {
                counter++;
            }    
        }
        
        int[] tempAvail = new int[counter];
        int tempCounter =0;
        for(int i=0; i <counter; i++)
        {
            if(available[i] != 0)
            {
                tempAvail[tempCounter++] = available[i];
            }
        }
        return tempAvail;
    }
}
