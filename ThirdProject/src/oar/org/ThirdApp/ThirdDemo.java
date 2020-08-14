package oar.org.ThirdApp;

import java.sql.*;

public class ThirdDemo 
{
	public static void main(String[] args) 
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		Statement stmt=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded and register.....");
			
			conn=DriverManager.getConnection(url);
			System.out.println("Connection established");
			
			stmt=conn.createStatement();
			System.out.println("Platform created");
		}
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
