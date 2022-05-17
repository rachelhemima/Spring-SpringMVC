package ai.jobiak.one;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cardholder")
public class CardHolderModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CardHolderModify() {
        super();      
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
		String fnameStr=request.getParameter("fname");
		String dobStr=request.getParameter("dob");
		String mobileStr=request.getParameter("mobile");
		Connection con=connect();
		try {			
			String query1 = "update aadhar set fullName=?,dob=? where mobile=?";
			PreparedStatement pst=con.prepareStatement(query1);
			pst.setString(1,fnameStr);
		    pst.setString(2,dobStr);
		    pst.setString(3,mobileStr);
		    //calling method
		    int i= pst.executeUpdate();
		    if(i>0)
		    	 System.out.println("Your Details Updated/Modified Sucessfully");
		  	 else
		  		 System.out.println("Record not found!!!");
			out.println("<a href='AadharStartPage.html'>Go back</a>");
			out.println("<a href='Singledata.html'>View Record</a>");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
