package ai.jobiak.two;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Context1")
public class Context1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Context1() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     PrintWriter out=response.getWriter();//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext context=getServletContext();
		int context1=Integer.parseInt(context.getInitParameter("num"));
		//square
		int res1=context1*context1;
		out.println("Square of Context Number:"+res1);
	}

}
