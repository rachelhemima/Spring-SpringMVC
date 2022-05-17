package ai.jobiak.two;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Context2
 */
@WebServlet("/Context2")
public class Context2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Context2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();//response.getWriter().append("Served at: ").append(request.getContextPath());
			ServletContext context=getServletContext();
			int context1=Integer.parseInt(context.getInitParameter("num"));
			//square
			int res1=context1*context1*context1;
			out.println("Cube of Context Number:"+res1);
	}

}
