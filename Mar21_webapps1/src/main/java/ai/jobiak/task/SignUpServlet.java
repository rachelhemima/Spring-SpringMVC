package ai.jobiak.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signuptest")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		String fname=request.getParameter("n1");
		String lname=request.getParameter("n2");
		String email=request.getParameter("n3");
		String password=request.getParameter("n4");
		Connection con=connect();
		try {
			PreparedStatement pst=con.prepareStatement("insert into signuptest values(?,?,?,?)");
		pst.setString(1,fname );
		pst.setString(2,lname );
		pst.setString(3,email );
		pst.setString(4,password);
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println("Records inserted");
	
	}
}
