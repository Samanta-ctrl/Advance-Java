package com.org.ForwardApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//from where i'm sending the data,we have to take from there
		String pname=(String) req.getAttribute("prdnm");
		String pqty=(String) req.getAttribute("prdqty");
		
		int qty=Integer.parseInt(pqty); //as quantity is integer type
		
		double price=60000.00;
		double totalsum=(price*qty);
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='black'><font color='red' size='20'>"
						+"Product Details:\n Product Name:- "
							+pname+"\t Product Quantity:- "
								+qty+"\t and Total Cost is:- "
									+totalsum+"</font></body></html>");
		out.flush();
		out.close();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String qry="insert into oejm5.product values(?,?,?)";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			pstmt=conn.prepareStatement(qry);
			pstmt.setString(1, pname);
			pstmt.setInt(2, qty);
			pstmt.setDouble(3, totalsum);
			pstmt.executeUpdate();
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
