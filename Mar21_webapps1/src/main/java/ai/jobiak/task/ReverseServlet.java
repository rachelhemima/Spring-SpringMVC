package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReverseServlet
 */
public class ReverseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReverseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><title>ReverseOfNumber Servlet</title></head><body>"); 
		int n1 = Integer.parseInt(request.getParameter("num"));
		int rem, rev = 0;
		while (n1 > 0) {
			rem = n1 % 10;
			rev = rev * 10 + rem;
			n1 = n1 / 10;
		}
	out.println("<h2>"+rev+"</h2>");	
	out.println("</body></html>");
	}
}
