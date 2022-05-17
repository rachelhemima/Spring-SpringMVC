package ai.jobiak.http;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private Connection connect() {
  		String userName = "root";
  		String password ="admin";
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String fnameStr=request.getParameter("fname");
	String emailStr=request.getParameter("email");
	String mobileStr=request.getParameter("mobile");
	response.getWriter().println(fnameStr+emailStr+mobileStr);
	Connection con=connect();
	int count=0;
	try {
		PreparedStatement pst=con.prepareStatement("insert into signup values(?,?,?)");
	pst.setString(1,fnameStr);
	pst.setString(2,emailStr);
	pst.setString(3,mobileStr);
		count=	pst.executeUpdate();
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
response.getWriter().println(count+"Record inserted");


	
	}
}
