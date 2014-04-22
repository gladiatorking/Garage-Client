



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jghibiki
 */
public class ServerMain extends Interfacing{
	public static void main(String [ ] args)
	{

		//Initialize server
		//1. Create multiple listening threads
		//2. Open ports on each thread
		//3. Begin listening on thread
		//4. Load garage server
		//5. Load user server
		//6. Jump to live run time environment loop
		//7. Show Admin interface form and wait for input
		//8. Loop until stutdown signal is recieved
		//9. Save and shut down user server
		//10. Save and shut down garage server
		//11. Safely close ports
		//12. Terminate extra listening threads
		//13. Exit 

        
        //1. Create listening threads
        
        //2. Open ports on each thread

        //3. Begin listening on threads
        
        //4. load garege server

        //5. Load user server
        
        //6. Jump to admin interface
        //7. Show admin interface form and wait for input
        /* will loop, creating new admin sessions until user tells the system to shut down, in which case
         *  the AdminSession function will return true, the loop here will end and we will begin shutting down the interface.
         */
        while(!AdminSession()); 

        //11. Safely close ports
        
        //12. Terminate listening threads
        
        //13. Exit
	}
	
	public static boolean AdminSession()
	{
        //A variable responsible for the shut-down state of the system
        //  if false, continues looping in the calling context, which will spawn
        //  a new AdminSession each time the loop iterates without terminating after wards
        boolean exit = false;
        
	//tracks if the current session should show.
	boolean endSession = false;
	
        //spawn an interface to prompt user to log in
        //#todo 



        //if user logs in sucessfully, spawn the Admin interface.
        //  Else, notify user of error and try again.
        Admin af = new Admin();
		af.setVisible(true);
	
	while(endSession== false)
	{
		;
	}
        //when user exits form, hide the form. and mark for garbage collection
        af.setVisible(false);
        af = null;


        return exit;
	}
}
