// Using preparedStatement interface

package oar.org.BatchApp;

import java.sql.*; 
public class Batch_Demo2 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String inqry="insert into oejm5.std values(13,'Naresh','ME',76.45)";
		String upqry="update oejm5.std set perc=70.67 where id=12";
		//String delqry="delete from oejm5.std where perc=71.60";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			
			pstmt1=con.prepareStatement(inqry);
			pstmt1.addBatch();
			int[] arr1=pstmt1.executeBatch();
			for(int i:arr1)
			{
				System.out.println(i);
			}
			
			pstmt2=con.prepareStatement(upqry);
			pstmt2.addBatch();
			int[] arr2=pstmt2.executeBatch();
			for(int j:arr2)
			{
				System.out.println(j);
			}
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
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt2!=null)
			{
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


