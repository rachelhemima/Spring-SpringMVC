package jobiak.jdbc.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) {
		//1.Connect with Driver Manager
				String userName = "root";
				String password = "admin";
				String url = "jdbc:mysql://localhost:3306/employee";
				try {
					Connection con = DriverManager.getConnection(url,userName, password);
					System.out.println("----Connection established------");		
					
					String query = "update emp set empName=?,empAge=? where empId=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, "Mickey");
				    pst.setInt(2, 30000);
				    pst.setInt(3, 1001);
				    //calling method
		          pst.executeUpdate();
		          System.out.println("--------Updated Sucessfully--------");
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}

	}

}
