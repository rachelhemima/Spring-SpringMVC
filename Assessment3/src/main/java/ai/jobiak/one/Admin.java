package ai.jobiak.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Admin() {
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
		Connection con=connect();
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select*from aadhar");  
            out.println("<table border=1 align=center width=60% height=20%>");  
            out.println("<tr><th>Fullname</th><th>Gender Id</th><th>Dob</th><th>Address</th><th>District</th><th>PinCode</th><th>Mobile</th><tr>");  
            while (rs.next()) 
            {  
            	String fnameStr=rs.getString("fullname");
        		String genderStr=rs.getString("gender");
        		String dobStr=rs.getString("dob");
        		String addressStr=rs.getString("address");
        		String distStr=rs.getString("district");
        		String pinStr=rs.getString("pincode");
        		String mobileStr=rs.getString("mobile");
                out.println("<tr><td>"+fnameStr +"+</td><td>"+genderStr +"</td><td>"+dobStr+"</td>+ <td>"+addressStr +"</td>+<td>"+distStr+"</td><td>"+pinStr+"<td>" + mobileStr+ "</td></tr>");   
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

}
