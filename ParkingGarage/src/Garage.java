
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
    private ArrayList<ParkingSession> NotAvailable = new ArrayList<>(maxSpots);
    private ArrayList<ParkingSession> Reserved = new ArrayList<>(maxSpots);
    
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
            if(b.getSpot() == newspot.getSpot()&& b.getFinishtime()> newspot.getStartingtime()
                    && b.getStartingtime()< newspot.getStartingtime())
            {
                return false;
            }
        }
        return true;
        
    }
    
    
    public boolean addCurrentSpot(ParkingSession newspot)
    {
        if(spotCheck(newspot))
        {
            NotAvailable.add(newspot.getSpot()-1, newspot);
            return true;
        }
      return false;      
    }
    
    public boolean addReserved(ParkingSession newReservation)
    {
        for(int a = 0; a<Reserved.size(); a++)
        {
        if(Reserved.get(a).getSpot()== newReservation.getSpot() && (Reserved.get(a).getStartingtime() < 
  newReservation.getStartingtime())  && (Reserved.get(a).getFinishtime()> newReservation.getFinishtime() ))
        {
            return false;
        }  
        }
        Reserved.add(newReservation);
        return true;
        }
    public boolean removeReservation(ParkingSession res,boolean before)
    {
        Calendar current = Calendar.getInstance();
        if(res.getStartingtime()< ((current.getTimeInMillis() *(1/3600000))+24)&& before)
                {
                   return false;
                }
        else
        {
            for(ParkingSession a: Reserved)
            {
                if(res.equals(a))
                {
                    Reserved.remove(a);
                    return true;
                }
            }
        }
        return false;
    }
    
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
    
    public int[] getUnavailableSpots()
    {
	    //NotAvailable
	    //Reserved
	    
	    //int[] temp = new int[maxSpots];
	    //for(int i=0; i<maxSpots; i++)
	    //{
		//    temp[i] = i;
	    //}
	    int counter1 = 0;
            Calendar now = Calendar.getInstance();
	    for(int i=0; i<Reserved.size(); i++)
	    {
		 if(Reserved.get(i) != null && ((Reserved.get(i).getStartingtime()*(1/60000))-15 < 
                         now.getTimeInMillis()*(1/60000))
                         && (Reserved.get(i).getFinishtime()> now.getTimeInMillis() ))
		 {
			 counter1++;
		 }
	    }
	    
	    int counter2 = 0;
	    for(int i=0; i<NotAvailable.size(); i++)
	    {
		 if(NotAvailable.get(i) != null)
		 {
			 counter2++;
		 }
	    }
	    
	    int counter3 = counter1 + counter2;
	    int pointer = 0;
	    
	    int[] temp = new int[counter3];
	    
	    for(int i=0; i<Reserved.size(); i++)
	    {
		 if(Reserved.get(i) != null && ((Reserved.get(i).getStartingtime()*(1/60000))-15 < 
                         now.getTimeInMillis()*(1/60000))
                         && (Reserved.get(i).getFinishtime()> now.getTimeInMillis() ))
		 {
			 counter1++;
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
    
    public int[] getAvailable(int[] unavailable)
    {
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
        for(int i=0; i <maxSpots; i++)
        {
            if(available[i] != 0)
            {
                tempAvail[counter++] = available[i];
            }
        }
        return tempAvail;
    }
}
