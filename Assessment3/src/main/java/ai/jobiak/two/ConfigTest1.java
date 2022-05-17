package ai.jobiak.two;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigTest1
 */
@WebServlet(
		urlPatterns = { "/ConfigTest1" }, 
		initParams = { 
				@WebInitParam(name = "FullName", value = "Hemima rachel"), 
				@WebInitParam(name = "MailId", value = "hemima@jobiak.com")
		})
public class ConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		         ServletConfig config=getServletConfig();
				String data1=config.getInitParameter("FullName");
				String data2=config.getInitParameter("MailId");		
	}
}
