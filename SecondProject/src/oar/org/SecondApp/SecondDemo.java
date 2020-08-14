//Second approach to load & register the driver into your java application.

package oar.org.SecondApp;
import java.sql.*;

public class SecondDemo 
{
	public static void main(String[] args)  
	{
		 Connection con=null;
		 try
		 {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded and registered");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection established");	
		 } 
		 catch (ClassNotFoundException | SQLException e) 
		 {
			e.printStackTrace();
		 }
		 finally
		 {
			 if(con!=null)
			 {
				 try
				 {
					 con.close();
					 System.out.println("con closed");
				 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
				 }
			 }
		 }
	}
}
