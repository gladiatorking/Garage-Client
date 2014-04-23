
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
    private int maxSpots;
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
    
    
    public boolean reservationcheck()
    {
        return true; //added return to temporarily remove error
    }
    public boolean addReserved(ParkingSession newReservation)
    {
        if(reservationcheck())
        {
            Reserved.add(newReservation);
            return true;
        }
        else
        {
            return false;
        }
        }
    public boolean removeReservation(ParkingSession res)
    {
        Calendar current = Calendar.getInstance();
        if(res.getStartingtime()< (current.getTimeInMillis() *(1/3600000)+24))
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
    
	public boolean makeAvailable(ParkingSession newSpot)
	{
		return true; //to hide errror
	}
    
    public int[] getAvailableSpots()
    {
	    //NotAvailable
	    //Reserved
	    
	    //int[] temp = new int[maxSpots];
	    //for(int i=0; i<maxSpots; i++)
	    //{
		//    temp[i] = i;
	    //}
	    int counter1 = 0;
	    for(int i=0; i<Reserved.size(); i++)
	    {
		 if(Reserved.get(i) != null)
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
}
