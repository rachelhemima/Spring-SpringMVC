package ai.jobiak.signupattribute;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpCreateServlet
 */
@WebServlet(name = "SignUpCreateServlet1", urlPatterns = { "/signupc" })
public class SignUpCreateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpCreateServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Connection connect()
    {
  		String userName = "root";
  		String password ="admin";
  		String url = "jdbc:mysql://localhost:3306/employee";
  		Connection conn=null;
  	try {
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		 conn = DriverManager.getConnection(url,userName, password);
  	     }
  	catch (SQLException | ClassNotFoundException e) 
  	{
  	e.printStackTrace();
  } 
  	return conn;
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection conn=connect();
		try 
        {  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery("select *from signup");
            rs.next();
			PrintWriter out= response.getWriter();
			ServletContext context =getServletContext();
			context.setAttribute("fname",rs.getString(1));
			context.setAttribute("email",rs.getString(2));
			context.setAttribute("mobile",rs.getString(3));
			
			request.setAttribute("fname",rs.getString(1));
			request.setAttribute("email",rs.getString(2));
			request.setAttribute("mobile",rs.getString(3));
			RequestDispatcher dispatcher=context.getRequestDispatcher("/signupr");
			dispatcher.forward(request, response);
        }  
         catch (Exception e) 
        {  
         	// TODO Auto-generated catch block
         	e.printStackTrace();
     }  

	}

}

