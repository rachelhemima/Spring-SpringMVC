package ai.jobiak.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/counterservlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=	response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		int counter=1;
		
		if(session.isNew()) {
			
			
			session.setAttribute("visits", counter+""); //1.User identity or token or 2.it could be the shopping cart
		}
		else {
			String counterStr=(String)session.getAttribute("visits");
			counter=Integer.parseInt(counterStr);
			counter++;
			session.setAttribute("visits",counter+"");
		}
		response.setContentType("text/html");
		out.println("<h3> You visited #"+counter+"</h3>");
		out.println("SessionID"+session.getId()+"\n");
		out.println("SessionMaxInterval"+session.getMaxInactiveInterval()+"\n");
		out.println("Last access time"+session.getLastAccessedTime()+"\n");
		out.println("<h3><a href='signout'>Signout</h3>");
		}

		

}
