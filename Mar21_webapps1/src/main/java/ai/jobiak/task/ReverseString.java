package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReverseString
 */
public class ReverseString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReverseString() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>ReverseOfString Servlet</title></head><body>"); 
		String Str=request.getParameter("str");
	String str2="";
	for(int i=Str.length()-1;i>=0;i--)
	{
	str2=str2+Str.charAt(i);	
	}
out.println("<h2>Reverse of given String: "+str2+"</h2>");
out.println("</body></html>");
	}

}
