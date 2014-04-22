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
public class AcessDatabase {
	static String garagedbLoc = "garage.db";
	static String userdbLc = "user.db";
	
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
				System.err.println("User database loaded sucessfully, but casting process failed.");
				return null;
			}
			
		}
		catch(Exception e)
		{
			System.err.println("Problem reading from user database.");
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
				System.err.println("Writing object failed.");
			}
		}
		catch(Exception e)
		{
			System.err.println("Error prepping the file output stream");
		}
	}
}
