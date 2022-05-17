package ai.jobiak.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServletRequest
 */
@WebServlet("/SignUpServletRequest")
public class SignUpServletRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServletRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("n1");
		String lastname=request.getParameter("n2");
		String emailid=request.getParameter("n3");
		String mobileno=request.getParameter("n4");
		
		//2.generate response
		//out.println("<h3> Hi Ms:"+name+"from S1 servlet</h3>");
		//3.RD
		RequestDispatcher rs=request.getRequestDispatcher("SignUpServletResponse");
		//4.set data to next next servlet
		request.setAttribute("key1",firstname);
		request.setAttribute("key2",lastname);
		request.setAttribute("key3",emailid);
		request.setAttribute("key4",mobileno);
		//5.call 
		rs.forward(request, response);
		
		
		}
	}


