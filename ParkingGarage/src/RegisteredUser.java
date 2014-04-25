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
	/**
         * RegisteredUser Constructor
         * @param fname
         * @param lname
         * @param creditCard
         * @param securityCode
         * @param expirationDate
         * @param address
         * @param city
         * @param state
         * @param zipCode
         * @param username
         * @param password
         * @param email
         * @param make
         * @param model
         * @param plateNumber 
         */
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
	/**
         * accessor of Email
         * @return email
         */
	public String getEmail()
	{
		return email;
	}
	/**
         * accessor of PlateNumber
         * @return plateNumber
         */
	public String getPlateNumber()
	{
		return plateNumber;
	}
	/**
         * accessor of getUsername
         * @return username
         */
	public String getUsername()
	{
		return username;
	}
        /**
         * accessor of getBill
         * @return bill
         */
        public int getBill()
        {
            return bill;
        }
        /**
         * accessor of getHours
         * @return time
         */
        public int getHours()
        {
            return time;
        }
        /**
         * Returns bill as a String
         * @return output 
         */
        public String billToString()
        {
            String output = "";
            
            output += "********************\n";
            output += "User: " + username + "\n";
            output += "Email: " + email + "\n";
            output += "Bill: " + (bill/100) + "\n";
            
            return output;
        }
        /**
         * sets hours
         * @param hours 
         */
        public void setHours(int hours)
        {
            time += hours;
        }
        /**
         * generates a bill using a rate
         * @param rate 
         */
        public void generateBill(int rate)
        {
            
            bill += time * rate;
            time = 0;
        }
        /**
         * pay bills that returns the payment in a int
         * @param payment
         * @return temp
         */
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
	/**
         * toString method
         * @return String
         */
	public String toString()
	{
		return super.toString()
			+ "Username: " + username
			+ "\nEmail: " + email 
			+ "\nPlate Number " + plateNumber + "\n";
	}
}
