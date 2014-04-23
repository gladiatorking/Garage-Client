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
	public String username;
	private String creditCard;
	private String securityCode;
	private String expirationDate;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String make;
	private String model;
	
	public RegisteredUser(
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
		super(fname, lname, password);
		this.email = email;
		this.plateNumber = plateNumber;
		this.username = username;
		

		this.creditCard = creditCard;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
		this.address = address;
		this.city = city;
		this.state = state;
		
		this.make = make;
		this.model = model;
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
