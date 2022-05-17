package ai.jobiak.ioc2;
import ai.jobiak.ioc.*;

public class UseConnection 
{
public UseConnection() {
	
	//Connection con=new Connection();
	NewConnection con=new NewConnection();
	con.getConnection();
	System.out.println("connection obtained is"+this.getClass());
}
}
