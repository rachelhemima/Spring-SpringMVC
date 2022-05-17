package ai.jobiak.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		out.println(request.getParameter("initial"));
		out.println(request.getParameter("fn"));
		out.println(request.getParameter("ln"));
		out.println(request.getParameter("ct"));
		out.println(request.getParameter("state"));
		out.println(request.getParameter("email"));
		out.println(request.getParameter("mob"));
		out.println(request.getParameter("add"));
	String languages[]=	request.getParameterValues("lk");
		for(String s:languages)
		{
			out.println(s);
		}
		 Enumeration  name=request.getParameterNames();
		 while(name.hasMoreElements())  {
		out.println("values="+request.getParameter(name.nextElement().toString()));
		 }
		}
}
