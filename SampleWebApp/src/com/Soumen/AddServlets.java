package com.Soumen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlets extends HttpServlet 
{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int i=Integer.parseInt(req.getParameter("num1")); // as getParameter will give u string so we have to convert it into integer
		int j=Integer.parseInt(req.getParameter("num2"));
		
		int add=i+j;
		//System.out.println("Total is "+add); //--> it will print here but not in web browser
		
		PrintWriter out=resp.getWriter();
		out.println("Result is: "+add);
		out.flush();
		out.close();
		
	}
	
}
