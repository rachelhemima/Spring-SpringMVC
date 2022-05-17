package jobiak.jdbc.curd;
import java.sql.*;
public class TestInsert {
	public static void main(String[] args) {
		//1.Connect with Driver Manager
				String userName = "root";
				String password = "admin";
				String url = "jdbc:mysql://localhost:3306/employee";
				try {
					Connection con = DriverManager.getConnection(url,userName, password);
					System.out.println("----Connection established------");		
	String query = " insert into emp (empId, empName,empAge)" + " values (?, ?, ?)";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setInt(1, 1003);
					pst.setString(2, "James");
					pst.setFloat(3, 25);
					//calling executeUpdate() for storing values
					pst.executeUpdate();
			         System.out.println("---------Values Inserted Successfully-----");   	 		
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
	}
}
