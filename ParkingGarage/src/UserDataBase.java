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
	
	private ArrayList<RegisteredUser> users ;
	public UserDataBase()
	{
		users = new ArrayList<>();
	}
	
	public void addUser(String fname, String lname, String password, String email, String plateNumber, String username)
	{
		users.add(new RegisteredUser(fname, lname, password, email, plateNumber, username));
		
	}
}


