package ai.jobiak.webapps;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleServlet implements Servlet {

	

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
		System.out.println("entered inti()");
		try {
			FileOutputStream fos=new FileOutputStream("Hello.txt");
			fos.write("This is added in init() to demostrate the timing of initi method".getBytes());
			fos.close();
			System.out.println("existing inti()");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().println("---this is from service() method---");
	
	}

	@Override
	public void destroy() {
		
		try {
			System.out.println("----entered destroy()---");
			FileOutputStream fos=new FileOutputStream("Hello.txt");
			fos.write("This is added in destroy() to demostrate the timing of destroy method".getBytes());
			fos.close();
			System.out.println("existing destroy()");
	Thread.currentThread().join();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
