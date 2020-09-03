package com.ForwardApp2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String pname=req.getParameter("pn");
		String pqty=req.getParameter("pq");
		
		req.setAttribute("prdnm", pname);
		req.setAttribute("prdqty", pqty);
		
		RequestDispatcher rd=req.getRequestDispatcher("ss"); //resource location of second project url-pattern as ss
		rd.forward(req, resp);
	}
}
