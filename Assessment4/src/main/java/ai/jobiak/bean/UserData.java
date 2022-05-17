package ai.jobiak.bean;
import java.sql.*;
public class UserData implements java.io.Serializable {
			private String fname;
			private String lname;
			private String mobile;
			private String mailId;
			String userName = "root";
			String password = "admin";
			String url = "jdbc:mysql://localhost:3306/test";
			
			public String getFname() {
				return fname;
			}
			public void setFname(String fname) {
				this.fname = fname;
			}
			public String getLname() {
				return lname;
			}
			public void setLname(String lname) {
				this.lname = lname;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
			public String getMailId() {
				return mailId;
			}
			public void setMailId(String mailId) {
				this.mailId = mailId;}
			
				
				public void insert() {
			try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(url,userName, password);
String sql="insert into contacts (fisrt_name, last_name,mobile,mail_id) values (fname, lname, mobile,mailId)";
						 Statement s = con.createStatement();
						  s.executeUpdate (sql);
						
					} 
					catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
