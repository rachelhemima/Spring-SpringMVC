package jobiak.jdbc.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestRetrive {

	public static void main(String[] args) {
		//1.Connect with Driver Manager
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/employee";
		try {
			Connection con = DriverManager.getConnection(url,userName, password);
			System.out.println("----Connection established------");		
			String query = " select*from emp";
			Statement st=con.createStatement();
			 System.out.println("---------Retriveing Values from emp table-----");   	 
			ResultSet rs=st.executeQuery(query);
			//fetching rows
			while(rs.next()) {
				System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
