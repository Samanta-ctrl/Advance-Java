package oar.org.DateApp;
import java.sql.*;
public class Date_Demo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		PreparedStatement pstmt=null;
		String qry1="insert into oejm5.date values(?)";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			
			pstmt=con.prepareStatement(qry1); //compile
			pstmt.setDate(1, new Date(1595484295000L)); // Millisecond value followed by long
			pstmt.executeUpdate();
			System.out.println("Data inserted...");
			con.close();
			pstmt.close();	
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
//		finally
//		{
//			if(con!=null)
//			{
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(pstmt!=null)
//			{
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
