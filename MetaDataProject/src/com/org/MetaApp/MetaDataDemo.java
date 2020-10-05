package com.org.MetaApp;

import java.sql.*;
import com.mysql.jdbc.DatabaseMetaData;

public class MetaDataDemo 
{
	public static void main(String[] args)
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		Statement stmt=null;
		ResultSet rs=null;
		String qry="select * from oejm5.student";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			
			DatabaseMetaData dbmd=(DatabaseMetaData) con.getMetaData();
			System.out.println("Driver class name--> "+dbmd.getDriverName());
			System.out.println("Driver class version--> "+dbmd.getDriverVersion());
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(qry);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("Total no. of columns--> "+rsmd.getColumnCount());
			System.out.println("Name of 3rd column--> "+rsmd.getColumnLabel(3));
			System.out.println("3rd columns display size--> "+rsmd.getColumnDisplaySize(3));
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		//close the costly resources
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
