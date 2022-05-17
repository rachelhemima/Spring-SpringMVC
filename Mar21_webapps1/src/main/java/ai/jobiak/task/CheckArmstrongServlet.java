package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckArmstrongServlet
 */
public class CheckArmstrongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckArmstrongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head><title>FactoralServlet</title></head><body>"); 
		int n = Integer.parseInt(request.getParameter("num"));
		int rem, arm = 0, temp;
		temp = n;
		while (n > 0) {
			rem = n % 10;
			arm = arm + (rem * rem * rem);
			n = n / 10;
		}
		if (temp == arm)
		  out.print("<h2>It is a Armstrong number ");
		else
			out.print("<h2>It is not a Armstrong number ");
		//out.println("arm");
	}

}
