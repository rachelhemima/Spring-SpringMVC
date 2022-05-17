package ai.jobiak.practice;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("cname");
		String mobile=request.getParameter("cmobile");
		//Cookie Creation
		Cookie c=new Cookie(name,mobile);		
		//adding data to cookie with response object
		response.addCookie(c);
		//for html printimg data
		 response.setContentType("text/html");  
         PrintWriter out = response.getWriter();  
   	     out.println("<h2><a href='getcookie'>View Cookie</h2><br/>");
         out.println("<h2><a href='cookie.html'>Add Cookie</h2><br/>");
         out.println("<h2><a href='deletecookie'>Delete Cookie</h2><br/>");
		
	
	}
}
