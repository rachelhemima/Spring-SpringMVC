package jobiak.jdbc.curd;
import java.sql.*;
public class TestCreate {
	public static void main(String[] args) {
		//1.Connect with Driver Manager
				String userName = "root";
				String password = "admin";
				String url = "jdbc:mysql://localhost:3306/employee";
				try {
					Connection con = DriverManager.getConnection(url,userName, password);
					System.out.println("----Connection established------");
					//creating statement for table
					 Statement stmt = con.createStatement();     
					 String query= "CREATE TABLE EMP " +
			                   "(empId INTEGER not NULL, " +
			                   " empName VARCHAR(255), " + 
			                   " empAge INTEGER, " + 
			                   " PRIMARY KEY ( empId ))"; 
					 //calling executeUpdate()
			         stmt.executeUpdate(query);
			         System.out.println("---------Table successfully created in Database-----");   	 	
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
	}
}
