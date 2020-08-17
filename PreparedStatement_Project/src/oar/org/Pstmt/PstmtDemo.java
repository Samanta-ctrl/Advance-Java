/*
 Code to insert multiple records into a single database server by using preparedStatement interface 
 along with placeholder.
 
 */

package oar.org.Pstmt;

import java.sql.*;
public class PstmtDemo 
{
	public static void main(String[] args) 
	{	
		Connection con=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		PreparedStatement pstmt=null;
		String qry="insert into oejm5.std values(?,?,?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			
			pstmt=con.prepareStatement(qry); //compile
			
			pstmt.setInt(1, 7);
			pstmt.setString(2, "Soumalya");
			pstmt.setString(3, "CSE");
			pstmt.setDouble(4, 73.20);
			
			pstmt.executeUpdate(); //execution of 1st record
			System.out.println("First record inserted");
			
			pstmt.setInt(1, 8);
			pstmt.setString(2, "Manas");
			pstmt.setString(3, "IT");
			pstmt.setDouble(4, 71.60);
			
			pstmt.executeUpdate(); //execution of 2nd record
			System.out.println("Second record inserted");
			
			pstmt.setInt(1, 9);
			pstmt.setString(2, "Arindam");
			pstmt.setString(3, "ECE");
			pstmt.setDouble(4, 76.10);
			
			pstmt.executeUpdate(); //execution of 3rd record
			System.out.println("Third record inserted");
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
		}
	}
}
