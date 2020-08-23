package com.FetchingApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String sid=req.getParameter("id");
		Connection con=null;
		PreparedStatement pstmt=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String qry="select * from oejm5.student where id= "+sid+" ";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); //loading Driver
			con=DriverManager.getConnection(url); //Establishing connection to the server
			pstmt=con.prepareStatement(qry); //for fetching data we have to make a statement	
			ResultSet res=pstmt.executeQuery(); //storing fetched data to the Resultset Interface
			
			PrintWriter out=resp.getWriter();
			out.println("<h1 style=\"text-align: center;\">Display the records</h1>");
		
			if(!res.next())
			{
				out.println("<h3 style=\"text-align: center; color: red\">Sorry! No such data found...</h3>");
			}
			else
			{
				out.println("<html><body bgcolor='yellow'><center><table border='1'><tr> <td>ID</td> <td>Name</td> <td>Depatment</td> <td>Percentage</td></tr>");
				out.println("<tr><td>"+res.getInt(1)+"</td> <td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getDouble(4)+"</td></tr>");
				out.println("</center></table></body></html>");
			}
			
			out.flush();
			out.close();
		}
		catch(Exception e)
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
	
