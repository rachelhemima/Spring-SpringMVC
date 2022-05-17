package ai.jobiak.webapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InsertServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/world";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,userName, password);
					out.println("Connected to db");
					Statement st=con.createStatement();
					String query = " insert into employee (empId, empName,empAge)" + " values (?, ?, ?)";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setInt(1, 1005);
					pst.setString(2, "James");
					pst.setFloat(3, 25);
					//calling executeUpdate() for storing values
					pst.executeUpdate();
			         out.println("---------Values Inserted Successfully-----");   	 	
				}
				catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}





}
