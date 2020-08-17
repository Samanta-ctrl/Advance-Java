package oar.org.Login_App;

import java.sql.*;
import java.util.Scanner;

public class Login_Validation 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select name from oejm5.user where username=? and password=?";
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Username");
		String uname=scn.next();
		System.out.println("Enter Password");
		String pwd=scn.next();
		scn.close();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			pstmt=con.prepareStatement(qry); //compile
			pstmt.setString(1,uname);
			pstmt.setString(2,pwd);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				String name=rs.getString(1);
				System.out.println("Welcome "+name);
			}
			else
				System.err.println("Invalid username or password");
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
		}
	}
}
