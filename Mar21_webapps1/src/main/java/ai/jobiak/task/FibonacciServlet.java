package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FactorialServlet
 */
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FibonacciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><title>Fibobacci Servlet</title></head><body>"); 
		int n = Integer.parseInt(request.getParameter("num"));
		 int i=1,f1=0,f2=1,f3;
		 out.println("<h2>The fibanocci is:");
         while(i<=n)
         {
  out.println(f1);
           f3=f1+f2;
           f1=f2;
           f2=f3;
           i=i+1; 
	}
     	 out.println("</body></html>");
	}

}
