package ai.jobiak.attributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAttribute
 */
@WebServlet("/create")
public class CreateAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAttribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		ServletContext context=getServletContext();
		context.setAttribute("dbName","mySQL");
		context.setAttribute("dbVersion","8.0.28");
		request.setAttribute("JdkVersion","17.01");
		request.setAttribute("Os","Windows 10");
		RequestDispatcher dispatcher=context.getRequestDispatcher("/read");
		dispatcher.forward(request, response);
		
		
	}

}
