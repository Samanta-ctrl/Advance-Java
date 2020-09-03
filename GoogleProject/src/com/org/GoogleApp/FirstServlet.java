package com.org.GoogleApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		resp.setContentType("text/html"); // what type of content u want
		resp.sendRedirect("https://www.google.co.in/#q="+name); //#q-->key
		
	}
}
