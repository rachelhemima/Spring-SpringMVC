package jobiak.jdbc.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {

	public static void main(String[] args) {
		//1.Connect with Driver Manager
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/test";
		try {
			Connection con = DriverManager.getConnection(url,userName, password);
			System.out.println("----Connection established------");		
			
			String query = "delete from aadhar where fullName=?";
			PreparedStatement pst=con.prepareStatement(query);
		    pst.setString(1,"h");
		    //calling method
          pst.executeUpdate();
          System.out.println("--------Deteled  Sucessfully--------");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
