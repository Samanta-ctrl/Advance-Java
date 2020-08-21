package oar.org.JDBC_App;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Demo2
{
	public static void main(String[] args) 
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		Savepoint sp=null;
		String qry1="insert into oejm5.std1 values(?,?,?,?)";
		String qry2="insert into oejm5.std2 values(?,?,?)";
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter id: ");
		int id=scn.nextInt();
		System.out.println("Enter name: ");
		String name=scn.next();
		System.out.println("Enter depatment: ");
		String dept=scn.next();
		System.out.println("Enter percentage: ");
		double perc=scn.nextDouble();
		System.out.println("Enter place: ");
		String place=scn.next();
		
		scn.close();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url);
			
			con.setAutoCommit(false);//disable auto commit feature to start the transaction
			//before beginning the transaction but after establishing the connection
			
			pstmt1=con.prepareStatement(qry1); //transaction starts
			
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, dept);
			pstmt1.setDouble(4, perc);
			pstmt1.executeUpdate();
			System.out.println("std1 table values are inserted");
			
			sp=con.setSavepoint(); //savepoint sp
			pstmt2=con.prepareStatement(qry2);
			
			pstmt2.setInt(1, id);
			pstmt2.setString(2, name);
			pstmt2.setString(3, place);
			pstmt2.executeUpdate();
			System.out.println("std2 table values are inserted");
			
			// if both the transaction are successful then we have commit
			con.commit(); //end of transaction
			System.out.println("Commited Successfully");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			try
			{
				//if any problem occurs
				con.rollback(sp);
				con.commit();
				System.out.println("Rolled back to second query! As there is some error/mistake");
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
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
