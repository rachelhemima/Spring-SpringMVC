package ai.jobiak.one;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/applicant")
public class ApplicantAadharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ApplicantAadharServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Connection connect() {
  		String userName = "root";
  		String password ="admin";
  		String url = "jdbc:mysql://localhost:3306/test";
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
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String fnameStr=request.getParameter("fname");
		String genderStr=request.getParameter("gender");
		String dobStr=request.getParameter("dob");
		String addressStr=request.getParameter("address");
		String distStr=request.getParameter("district");
		String pinStr=request.getParameter("pin");
		String mobileStr=request.getParameter("mobile");
		Connection con=connect();
		try {
			PreparedStatement pst=con.prepareStatement("insert into aadhar values(?,?,?,?,?,?,?)");
		pst.setString(1,fnameStr);
		pst.setString(2,genderStr);
		pst.setString(3,dobStr);
		pst.setString(4,addressStr);
		pst.setString(5,distStr);
		pst.setString(6,pinStr);
		pst.setString(7,mobileStr);
	    pst.executeUpdate();
	    out.println("Application Successfully registered<br/>");
		out.println("<a href='AadharStartPage.html'>Home</a>");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	}
		
	
