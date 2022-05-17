package ai.jobiak.ioc;

public class NewConnection {
public NewConnection getConnection()
{
System.out.println("providing the NewConnection....");
return new NewConnection();
}
}
