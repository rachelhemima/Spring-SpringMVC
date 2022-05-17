package ai.jobiak.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServletResponse
 */
@WebServlet("/SignUpServletResponse")
public class SignUpServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServletResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
response.setContentType("text/html");
		String fn=(String) request.getAttribute("key1");
		String ln=(String) request.getAttribute("key2");
		String em=(String) request.getAttribute("key3");
		String mo=(String) request.getAttribute("key4");
		out.println("<h3>FullName: "+fn+"</h3>");
		out.println("<h3>LastName:"+ln+"</h3>");
		out.println("<h3>Email:"+em+"</h3>");
		out.println("<h3> Mobile no:"+mo+"</h3>");
	}

}
