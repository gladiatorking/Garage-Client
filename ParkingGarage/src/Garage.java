
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
    private ArrayList<ParkingSession> notAvailable;
   private ArrayList<ParkingSession> Reservation;
 
    public Garage() {
        this.notAvailable = new ArrayList<ParkingSession>();
        this.Reservation = new ArrayList<ParkingSession>();
    }
    public boolean spotCheck(ParkingSession newspot)
    {
        for(ParkingSession a : notAvailable)
        {
            if(a.getSpot() == newspot.getSpot())
            {
                return false;
            }
        }
        for(ParkingSession b : Reservation)
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
            notAvailable.add(newspot);
            return true;
        }
      return false;      
    }
    public boolean reservationcheck(ParkingSession newspot){
        
    }
    public boolean addReservation(ParkingSession newReservation){
        if(reservationcheck())
        {
            Reservation.add(newReservation);
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
            for(ParkingSession a: Reservation)
            {
                if(res.equals(a))
                {
                    Reservation.remove(a);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean makeAvailable(ParkingSession newSpot)
    {
        
    }
}
