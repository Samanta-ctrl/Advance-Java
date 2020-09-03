package com.ForwardApp2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String pname=req.getParameter("pn");
		String pqtr=req.getParameter("pq");
		//but quantity is String type so here,so we have to convert it into Integer type
		int qty=Integer.parseInt(pqtr);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String qry="select * from oejm5.product where pn= "+pname+"and pq="+qty;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			pstmt=conn.prepareStatement(qry);
			ResultSet res= pstmt.executeQuery();
			
			PrintWriter out=resp.getWriter();
			//if(pname=="vivo")
				out.println("<html><body bgcolor='yellow'><font color='red' size='20'>"+"Product Details........\n \t Product Name: "+res.getString(1)+"\n\t Quantity: "+res.getInt(2)+"\n\t Total Cost: "+res.getDouble(3)+"</font></body></html>");	
			//else
				//out.println("No such product avialable");
			out.flush();
			out.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
