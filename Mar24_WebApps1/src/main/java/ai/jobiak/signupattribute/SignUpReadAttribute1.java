package ai.jobiak.signupattribute;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpReadAttribute1
 */
@WebServlet("/signupr")
public class SignUpReadAttribute1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpReadAttribute1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		ServletContext context=getServletContext();
		out.println("From Database");
		out.println("FirstName:"+context.getAttribute("fname"));
		out.println("Email :"+context.getAttribute("email"));
		out.println("Mobile :"+context.getAttribute("mobile"));
		out.println("FirstName:"+request.getAttribute("fname"));
		out.println("Email :"+request.getAttribute("email"));
		out.println("Mobile :"+request.getAttribute("mobile"));

	}

}
