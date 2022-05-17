package ai.jobiak.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/getcookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
	//getting cookie
	Cookie c[]=request.getCookies(); 
	if(c!=null)
		for(int i=0;i<c.length;i++)
		{
			//print by array cookie
			out.println("<h3>Name:"+c[i].getName()+"</h3>");
			out.println("<h3>Mobile:"+c[i].getValue()+"</h3>");
			out.println("<h3>------------------------------------</h3>");
			//out.println("<h3>Email:"+c[i].getName()+"</h3>");
		}
		else
			out.println("<h3>No cookies found!!!</h3>");
	
	}
  
}


