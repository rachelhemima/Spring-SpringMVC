package ai.jobiak.mvc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class UserDao {
 private JdbcTemplate mysqlTemplate;
	public JdbcTemplate getMysqlTemplate() {
		return mysqlTemplate;
	}

	public void setMysqlTemplate(JdbcTemplate mysqlTemplate) {
		this.mysqlTemplate = mysqlTemplate;
	}

	public Boolean insertRow(String fname,long mobile,String email) 
	{
		String query="insert into signup values(?,?,?)";
		return mysqlTemplate.execute(query,new PreparedStatementCallback<Boolean>()
			{
public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException
	{
		ps.setString(1, fname);
		ps.setString(3, email);
		ps.setLong(2, mobile);
		return ps.execute();
	}	
	});
}
	public Boolean updateRow(long mobile,String email,String fname) 
	{
		String query="update signup set mobile=?,email=? where fname=?";
		return mysqlTemplate.execute(query,new PreparedStatementCallback<Boolean>()
			{
public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException
	       {
	    ps.setLong(1, mobile);
		ps.setString(2, email);
		ps.setString(3, fname);
		return ps.execute();
	}	
	});
}
	public Boolean deleteRow(String fname) 
	{
		String query="delete from signup where fname=?";
		return mysqlTemplate.execute(query,new PreparedStatementCallback<Boolean>()
			{
public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException
	       {
		ps.setString(1, fname);
		return ps.execute();
	}	
	});
}
}
