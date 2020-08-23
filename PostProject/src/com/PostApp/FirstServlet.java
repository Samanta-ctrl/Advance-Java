package com.PostApp;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String eid=req.getParameter("i");
		int id=Integer.parseInt(eid); // for integer to string
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String perc=req.getParameter("pc");
		double per=Double.parseDouble(perc);
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='black'><font color='red' size='20'>Welcome "+name+" to "+dept+" deptartment.</font><body></html>");
		out.flush();
		out.close();
		
	//------------------------------------------------------------
		
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		PreparedStatement pstmt=null;
		String qry="insert into oejm5.student values(?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			pstmt=conn.prepareStatement(qry);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, per);
			pstmt.executeUpdate();
			System.out.println("Student table values are inserted..");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		//closing costly resources 
		finally 
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
