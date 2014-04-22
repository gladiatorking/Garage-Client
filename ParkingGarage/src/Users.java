/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jghibiki
 */
public class Users {
	private String fname;
	private String lname;
	private String password;
	
	public Users(String fname, String lname, String password)
	{
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}
	
	public String getFName()
	{
		return fname;
	}
	
	public String getLName()
	{
		return lname;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String toString()
	{
		return "Name:" + lname + ", " + fname + "\n";
	}
}
