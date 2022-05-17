package ai.jobiak.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
@WebServlet("/S1")
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");
		//1.data from html
		String name=request.getParameter("n1");
		//2.generate response
	out.println("<h3>Hi Ms: "+name+"from S1 servlet</h3>");
		//3.RD
	RequestDispatcher rs=request.getRequestDispatcher("S2");
		//4.set data to next next servlet
		request.setAttribute("key",name);
		//5.call 
		rs.forward(request, response);
		
		
		
	
	
	
	
	
	
	}
}
