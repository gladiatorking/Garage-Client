package Server;


import Common.Interfacing;



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


		
		Admin af = new Admin();
		af.setVisible(true);
	}
}
