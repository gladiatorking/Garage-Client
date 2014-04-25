/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
/**
 *
 * @author jghibiki
 */
public class Users implements Serializable{
	private String fname;
	private String lname;
	private String password;
	/**
         * consturctor of Users
         * @param fname
         * @param lname
         * @param password 
         */
	public Users(String fname, String lname, String password)
	{
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}
	/**
         * accessor of FNAme
         * @return fname
         */
	public String getFName()
	{
		return fname;
	}
	/**
         * accessor of lName
         * @return lname
         */
	public String getLName()
	{
		return lname;
	}
	/**
         * accessor of password
         * @return password
         */
	public String getPassword()
	{
		return password;
	}
	/**
         * toString method
         * @return String
         */
	public String toString()
	{
		return "Name:" + lname + ", " + fname + "\n";
	}
}
