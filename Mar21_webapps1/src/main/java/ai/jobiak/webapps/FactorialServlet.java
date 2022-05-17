package ai.jobiak.webapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FactorialServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		int n=5;
		int fact=1;
		for(int i=1;i<=n;i++)
		{
			fact*=i;
		}
		out.println("The factorial of 5 is :"+fact);
		
		ArrayList<String> list=new ArrayList<>();
		list.add("Orange");
		list.add("Blue");
		list.add("Red");
		list.add("White");
		for(String color:list)
		{
			out.println(color+"::"+color.length());
		}
HashMap<String,String> techInventors=new  HashMap();
techInventors.put("Java", "james Gosling");
techInventors.put("Cpp", " Bjarne Strostup");
techInventors.put("C", " Dennis Ritchie");
techInventors.put("Linux", " Linus Torvalds");
techInventors.put("Python", "Guido van Rossum");
out.println(techInventors);
	Set<String> keys =techInventors.keySet();
	for(String key:keys)
	{
		out.println(techInventors.get(keys)+": Length of value-->"+techInventors.get(keys).length());
	}
	}

}
