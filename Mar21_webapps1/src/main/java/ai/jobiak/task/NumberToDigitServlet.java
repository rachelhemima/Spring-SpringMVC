package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberToDigitServlet
 */
public class NumberToDigitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberToDigitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
PrintWriter out=response.getWriter();
response.setContentType("text/html;charset=UTF-8");
out.println("<html><head><title>FactoralServlet</title></head><body>"); 
int n = Integer.parseInt(request.getParameter("num"));
out.println();
while (n > 0) {
	int rem;
	rem = n % 10;
	out.print("<h2>"+rem+",");
	n = n / 10;
}
out.print("</body></html>");
	}

}
