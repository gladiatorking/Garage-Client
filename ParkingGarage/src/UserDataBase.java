import java.util.ArrayList;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jghibiki
 */
public class UserDataBase implements Serializable{
	
	public ArrayList<RegisteredUser> users ;
	public UserDataBase()
	{
		users = new ArrayList<>();
	}
	
	public void addUser(
		String fname, 
		String lname, 
		String creditCard,
		String securityCode,
		String expirationDate,
		String address,
		String city,
		String state,
		String zipCode,
		
		
		String username,
		String password, 
		String email, 
		
		String make,
		String model,
		String plateNumber
		
	)
	{
		users.add(new RegisteredUser(
			fname, 
			lname, 
			creditCard,
			securityCode,
			expirationDate,
			address,
			city,
			state,
			zipCode,
			
			
			username,
			password, 
			email, 
			
			make,
			model,
			plateNumber	
		));
		
	}
}


