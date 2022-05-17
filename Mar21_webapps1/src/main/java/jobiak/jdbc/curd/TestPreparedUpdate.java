package jobiak.jdbc.curd;
import java.sql.*;
public class TestPreparedUpdate {
	public static void main(String[] args) {
		//1.Connect with Driver Manager
				String userName = "root";
				String password = "admin";
				String url = "jdbc:mysql://localhost:3306/employee";
				try {
					Connection con = DriverManager.getConnection(url,userName, password);

String names[]= {"Hemi","honey","priya","chintu","cheery"};
int sal[]= {3000,2000,40000,5000,8000};
					System.out.println("----Connection established------");		
	String query = " insert into emp (empId, empName,empAge)" + " values (?, ?, ?)";
				for(int i=1;i<names.length;i++) {
	PreparedStatement pst=con.prepareStatement(query);
					pst.setInt(1, i+103);
					pst.setString(2, names[i]);
					pst.setFloat(3, sal[i]);
					//calling executeUpdate() for storing values
			int count=pst.executeUpdate();
			         System.out.println(count+" row inserted");   	 		
				}
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			
	}
}
