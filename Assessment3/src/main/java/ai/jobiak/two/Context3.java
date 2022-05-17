package ai.jobiak.two;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context3
 */
@WebServlet("/Context3")
public class Context3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Context3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();//response.getWriter().append("Served at: ").append(request.getContextPath());
			ServletContext context=getServletContext();
			int context1=Integer.parseInt(context.getInitParameter("num"));
		int power = 1;  
		int exponent=2;
		for (int i = 1; i <= exponent; i++)   
		power = context1 * exponent;  
		out.println("Power of 2 Context Number:"+power);
		}	
}
