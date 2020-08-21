//using Statement Interface

package oar.org.BatchApp;
import java.sql.*;
public class Batch_Demo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String inqry="insert into oejm5.std values(12,'Poltu','EEE',50.25)";
		String upqry="update oejm5.std set perc=80.67 where perc=73.20";
		String delqry="delete from oejm5.std where perc=71.60";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			
			stmt=con.createStatement();
			stmt.addBatch(inqry);
			stmt.addBatch(upqry);
			stmt.addBatch(delqry);
			con.close();
			stmt.close();
			
			int[] arr=stmt.executeBatch();
			for(int i:arr)
			{
				System.out.println(i);
			}
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
//			if(stmt!=null)
//			{
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
