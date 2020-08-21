package CstmtApp;

import java.sql.*;
import java.util.Scanner;
public class Cstmt_Demo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		CallableStatement cstmt=null;
		ResultSet rs=null;
		String qry="{call oejm5.stdproc(?)}";
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter id: ");
		int id=scn.nextInt();
		scn.close();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			cstmt=con.prepareCall(qry);
			cstmt.setInt(1, id);
			rs=cstmt.executeQuery();
			
			if(rs.next())
			{
				String name=rs.getNString(1);
				System.out.println("Welcome "+name);
			}
			else
			{
				System.err.println("Enter id is not available");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
