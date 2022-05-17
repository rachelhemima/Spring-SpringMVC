package ai.jobiak.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class CounterServlet1 extends HttpServlet {
private static final long serialVersionUID = 1L;
    public CounterServlet1() {
        super();   
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());

	HttpSession session=request.getSession();
	int counter=1;
	if(session.isNew())
	{
			session.setAttribute("visits", counter+"");	
	}
	else
	{
			String	counterStr=(String)session.getAttribute("visits");
			counter=Integer.parseInt(counterStr);
			counter++;
			session.setAttribute("visits", counter+"");
	}
response.setContentType("text/html");
out.println("<h3>You vistited #:"+counter+"</h3>");
out.println("<h3>You vistited #:"+counter+"</h3>");
out.println("<h3>You vistited #:"+counter+"</h3>");
	}
}
