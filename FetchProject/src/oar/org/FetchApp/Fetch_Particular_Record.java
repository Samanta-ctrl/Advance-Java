package oar.org.FetchApp;

import java.sql.*;
import java.util.Scanner;
public class Fetch_Particular_Record 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from oejm5.std";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		Scanner scn=new Scanner(System.in);
		System.out.println("enter which record you want to fetch: ");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			if(rs.absolute(scn.nextInt()))
			{
				int id=rs.getInt("id");
				String name=rs.getString(2);
				String branch=rs.getString(3);
				double perc=rs.getDouble("perc");
				System.out.println("Student details: "+id+" "+name+" "+branch+" "+perc);
			}
			else
				System.err.println("No such record found");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
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
			if(pstmt!=null)
			{
				try {
					pstmt.close();
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
			scn.close();
		}
	}
}
