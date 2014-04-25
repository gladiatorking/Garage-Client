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
        private int bill;
        private int time;
	
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
                this.bill = 0;
                this.time = 0;
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
        
        public int getBill()
        {
            return bill;
        }
        
        public int getHours()
        {
            return time;
        }
        
        public String billToString()
        {
            String output = "";
            
            output += "********************\n";
            output += "User: " + username + "\n";
            output += "Email: " + email + "\n";
            output += "Bill: " + (bill/100) + "\n";
            
            return output;
        }
        
        public void setHours(int hours)
        {
            time += hours;
        }
        
        public void generateBill(int rate)
        {
            bill += time * rate;
            time = 0;
        }
        public int payBill(int payment)
        {
            int temp = bill - payment;
            
            if(temp >= 0)
            {
                bill = temp;
                return 0;
            }
            else
            {
                bill = 0;
                return -temp; //returns the overage payment
            }
        }
	
	public String toString()
	{
		return super.toString()
			+ "Username: " + username
			+ "\nEmail: " + email 
			+ "\nPlate Number " + plateNumber + "\n";
	}
}
