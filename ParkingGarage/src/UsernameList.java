
import java.util.ArrayList;
import java.util.Arrays;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jghibiki
 */
public class UsernameList {
	static String[] usernames;

	
	
	public static void initUsernames()
	{
		UsernameList.usernames = new String[0];
	}
	public static void addUsername(String username)
	{
		
		String[] temp = new String[UsernameList.usernames.length+1];
		
		for(int i=0; i < UsernameList.usernames.length; i++)
		{
			temp[i] = UsernameList.usernames[i];
		}
		
		temp[UsernameList.usernames.length-1] = username;
		
		UsernameList.usernames = new String[temp.length];
		
		for(int i=0; i <temp.length; i++)
		{
			UsernameList.usernames[i] = temp[i];
		}
	}
	
	public static void removeUsername(String name)
	{
		ArrayList<String>list = new ArrayList<>(Arrays.asList(name));
		
		for(String i : list)
		{
			list.remove(name);
		}
		
		UsernameList.usernames = new String[list.size()];
		//for(int i=0; )
		
	}
	
	public static String getUsernameList()
	{
		String output = "";
		int width = 3;
		int currentWidth = 1;
		
		for(int i = 0; i < UsernameList.usernames.length; i++)
		{
			if (currentWidth > 0 && currentWidth < 3)
			{
				output += i + " " + UsernameList.usernames[i] + "\t"; 
				
				currentWidth++;
			}
			else if(currentWidth == 3)
			{
				output += "\n";
				currentWidth = 1;
			}
		}
		
		
		return output;
	}
}
