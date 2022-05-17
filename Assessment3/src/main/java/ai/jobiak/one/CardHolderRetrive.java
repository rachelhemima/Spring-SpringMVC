package ai.jobiak.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardHolderRetrive")
public class CardHolderRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CardHolderRetrive() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		Connection con=connect();
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        String data1=request.getParameter("fname");
        try 
        {   
        PreparedStatement pst=con.prepareStatement("select *from aadhar where fullname=?");
            ResultSet rs = pst.executeQuery();  
            	pst.setString(1,data1);
            out.println("<table border=1 align=center width=20% height=20%>");  
            out.println("<tr><th>FirstName</th><th>Email Id</th><th>Mobile</th><tr>");  
            while (rs.next()) 
            {  
            	String fnameStr=rs.getString("fname");
        		String genderStr=rs.getString("gender");
        		String dobStr=rs.getString("dob");
        		String addressStr=rs.getString("address");
        		String distStr=rs.getString("district");
        		String pinStr=rs.getString("pin");
        		String mobileStr=rs.getString("mobile");
                out.println("<tr><td>" + fnameStr + "</td><td>" + genderStr + "</td><td>" + dobStr + "</td>+ <td>" + addressStr + "</td>+<td>" + distStr+ "</td>+<td>" + distStr+"</td><td>"+pinStr+"<td>" + mobileStr+ "</td></tr>");   
            }  
            out.println("</table>");  
            con.close();  
			out.println("<a href='AadharStartPage.html'>Go back</a>");
           }  
            catch (Exception e) 
           {  
            	// TODO Auto-generated catch block
            	e.printStackTrace();
        }  
	}
}
