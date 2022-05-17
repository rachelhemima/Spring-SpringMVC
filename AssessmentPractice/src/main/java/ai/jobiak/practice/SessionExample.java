package ai.jobiak.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionExample
 */
@WebServlet("/SessionExample")
public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//1.get form data
		String fname=request.getParameter("n1");
		String lname=request.getParameter("n2");
		//http session creation
		HttpSession hs=request.getSession();
		hs.setAttribute("key1",fname);
		hs.setAttribute("key2",lname);
		out.println("<a href=S2?x="+fname+"&y="+lname+">Go to Servlet</a>");
   //  response.sendRedirect("OkaySession");
//	RequestDispatcher rd=request.getRequestDispatcher("OkaySession");
//	rd.forward(request, response);
//	rd.include(request, response);
		
		
	
		
	}
}
