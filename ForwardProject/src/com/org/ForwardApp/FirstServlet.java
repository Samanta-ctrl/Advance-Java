package com.org.ForwardApp;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String pname=req.getParameter("pn");
		String pqty=req.getParameter("pq");
		
		req.setAttribute("prdnm", pname);
		req.setAttribute("prdqty", pqty);
		
		RequestDispatcher rd=req.getRequestDispatcher("ss");
		rd.forward(req, resp);
		
	}
}
