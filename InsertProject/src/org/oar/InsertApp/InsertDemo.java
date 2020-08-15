package org.oar.InsertApp;

import java.sql.*;
import java.util.Properties;

public class InsertDemo 
{
	public static void main(String[] args)
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306";
		Statement stmt=null;
		//String inqry="insert into oejm5.std values(3,'Ashish','ECE',70.6)";
		
		//String upqry="update oejm5.std set perc=90.5 where id=2";
		
		String delqry="delete from oejm5.std where id=3";
		
		Properties info=new Properties();
		info.put("user","root");
		info.put("password", "root");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded and register...");
			
		
            con=DriverManager.getConnection(url,info);
		    System.out.println("Connection Established..");
				
			stmt=con.createStatement();
			System.out.println("Platform created");
				
			/*INSERT
			stmt.executeUpdate(inqry);
			System.out.println("Data inserted succesfully"); */
			
			/* UPDATE
			stmt.executeUpdate(upqry);
			System.out.println("Data updated Successfully"); */
			
			//DELETE
			stmt.executeUpdate(delqry);
			System.out.println("Data deleted successfully");
				
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				
				try 
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(stmt!=null) 
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
