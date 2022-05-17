package ai.jobiak.one;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardHolder")
public class CardHolder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CardHolder() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static Connection connect() {
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
  	public static boolean checkUserIdPswd(String mid,String pswd)
  	{
  		boolean temp=false;
  			try {
  				Connection con=connect();
  				PreparedStatement pst=con.prepareStatement("select * from login where Mailid=? and Password=?");
  				pst.setString(1,mid);
  				pst.setString(2, pswd);
  				ResultSet rs=pst.executeQuery();
  				temp=rs.next();
  				pst.close();
  			} 
  			catch (Exception e) 
  			{
  			e.printStackTrace();
  			}
  			return temp;
  	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//1.Get Html form data
		String data1=request.getParameter("mailid");
		String data2=request.getParameter("password");
		if(checkUserIdPswd(data1,data2)==true)
		{
		out.println("Login Succesful!!!<br/>");
		out.println("<a href='aadhar.html'>Apply For Aadhar</a></br>");
		out.println("<a href='CardHolderRetrive'>View Aadhar Card</a></br>");
		out.println("<a href='cardholder'>Modify data</a></br>");
	
		}}
}
