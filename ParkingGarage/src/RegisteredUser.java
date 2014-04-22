/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jghibiki
 */
public class RegisteredUser extends Users{
	private String email;
	private String plateNumber;
	private String username;
	
	public RegisteredUser(String fname, String lname, String password, String email, String plateNumber, String username)
	{
		super(fname, lname, password);
		this.email = email;
		this.plateNumber = plateNumber;
		this.username = username;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPlateNumber()
	{
		return plateNumber;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String toString()
	{
		return super.toString()
			+ "Username: " + username
			+ "\nEmail: " + email 
			+ "\nPlate Number " + plateNumber + "\n";
	}
}
