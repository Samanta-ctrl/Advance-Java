package com.org.TimerApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/td") //using annotation
public class TimeDemo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setIntHeader("Refresh", 1);//1st- how ,2nd -when we have to do
		resp.setContentType("text/html");
		
		Calendar cd=new GregorianCalendar();
		String am_pm;
		
		int hour=cd.get(Calendar.HOUR);
		int min=cd.get(Calendar.MINUTE);
		int sec=cd.get(Calendar.SECOND);
		int msec=cd.get(Calendar.MILLISECOND);
		
		if(cd.get(Calendar.AM_PM)==0)
		{
			am_pm="AM";
		}
		else
		{
			am_pm="PM";
		}
		
		String ct=hour+":"+min+":"+sec+":"+msec+" "+am_pm;
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='black'><font color='white' size='18' align='center'>"
				+"Current Time -->"+ct+"</font></body></html>");
		out.flush();
		out.close();
	}
}
