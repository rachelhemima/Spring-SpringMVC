package ai.jobiak.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayData
 */
public class DisplayData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private Connection connect() {
  		String userName = "root";
  		String password = "admin";
  		String url = "jdbc:mysql://localhost:3306/employee";
  		Connection con=null;
  	try {
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		 con = DriverManager.getConnection(url,userName, password);
  	     }
  	catch (SQLException e) 
  	{
  	e.printStackTrace();
  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	return con;
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fnameStr=request.getParameter("fname");
		String emailStr=request.getParameter("email");
		String mobileStr=request.getParameter("mobile");
		
		Connection con=connect();
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from signup");  
            out.println("<table border=1 align=center width=20% height=20%>");  
            out.println("<tr><th>FirstName</th><th>Email Id</th><th>Mobile</th><tr>");  
            while (rs.next()) 
            {  
                String name = rs.getString("fname");  
                String email = rs.getString("email");  
                String mobile = rs.getString("mobile");  
                out.println("<tr><td>" + name + "</td><td>" + email + "</td><td>" + mobile + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            	// TODO Auto-generated catch block
            	e.printStackTrace();
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
