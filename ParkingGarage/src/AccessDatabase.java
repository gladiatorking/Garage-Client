/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jghibiki
 */
public class AccessDatabase {
	static String garagedbLc = "garage.db";
	static String userdbLc = "user.db";
	
	public static void InitDBs()
	{
		try
		{
			OutputStream fis = new FileOutputStream(userdbLc);
			OutputStream bis = new BufferedOutputStream(fis);
			ObjectOutput ois = new ObjectOutputStream(bis);
			
			try
			{
				ois.writeObject(new UserDataBase());
			}
			catch(Exception e)
			{
				System.err.println("Error writing initial user db.\n" + e);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error initializing user db.\n" + e);
		}
		try
		{
			OutputStream fis = new FileOutputStream(garagedbLc);
			OutputStream bis = new BufferedOutputStream(fis);
			ObjectOutput ois = new ObjectOutputStream(bis);
			
			try
			{
				//ois.writeObject(new GarageDB());
			}
			catch(Exception e)
			{
				System.err.println("Error writing initial garage db.\n" + e);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error intializing garage db.\n" + e);
		}
	}
	
	public static UserDataBase readUserDB()
	{
		try
		{
			InputStream fis = new FileInputStream(userdbLc);
			InputStream bis = new BufferedInputStream(fis);
			ObjectInput ois = new ObjectInputStream(bis);
			
			try
			{
				return (UserDataBase) ois.readObject();
			}
			catch(Exception e)
			{
				System.err.println("User database loaded sucessfully, but casting process failed.\n" + e);
				return null;
			}
			
		}
		catch(Exception e)
		{
			System.err.println("Problem reading from user database.\n" + e);
			return null;
		}
	}
	
	public static void writeUserDB(UserDataBase udb)
	{
		try
		{
			OutputStream fis = new FileOutputStream(userdbLc);
			OutputStream bis = new BufferedOutputStream(fis);
			ObjectOutput ois = new ObjectOutputStream(bis);
			
			try
			{
				ois.writeObject(udb);
			}
			catch(Exception e)
			{
				System.err.println("Writing object failed.\n" + e);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error prepping the file output stream.\n" + e);
		}
	}
	
}
