package oar.org.LIfeApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/fs",loadOnStartup = 2)
public class FirstServlet extends GenericServlet 
{
	public FirstServlet()
	{
		System.out.println("Servlet object is created..");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Servlet object is initialized");
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'><font color='blue' size='20'>Welcome "+name+" to "+place+"</font></body></html>");
		out.flush();
		out.close();
	}

	@Override
	public void destroy() 
	{
		System.out.println("Costly resources are closed");
	}	
	
}
