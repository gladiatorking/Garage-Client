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
	/**
         * initialize Database
         */
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
				ois.close();
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
				ois.writeObject(new Garage());
                                ois.close();
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
	/**
         * reads user database
         * @return UserDataBase
         */
	public static UserDataBase readUserDB()
	{
		try
		{
			InputStream fis = new FileInputStream(userdbLc);
			InputStream bis = new BufferedInputStream(fis);
			ObjectInput ois = new ObjectInputStream(bis);
			
			try
			{
				UserDataBase udb = (UserDataBase) ois.readObject();
				ois.close();
				return udb;
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
	/**
         * writes to the userdatabase
         * @param udb 
         */
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
				ois.close();
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
        /**
         * reads The Garage database
         * @return Garage
         */
        public static Garage readGarageDB()
	{
		try
		{
			InputStream fis = new FileInputStream(garagedbLc);
			InputStream bis = new BufferedInputStream(fis);
			ObjectInput ois = new ObjectInputStream(bis);
			
			try
			{
				Garage gdb = (Garage) ois.readObject();
				ois.close();
				return gdb;
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
        /**
         * writes to GarageDatabase
         * @param gdb 
         */
        public static void writeGarageDB(Garage gdb)
	{
		try
		{
			OutputStream fis = new FileOutputStream(garagedbLc);
			OutputStream bis = new BufferedOutputStream(fis);
			ObjectOutput ois = new ObjectOutputStream(bis);
			
			try
			{
				ois.writeObject(gdb);
				ois.close();
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
