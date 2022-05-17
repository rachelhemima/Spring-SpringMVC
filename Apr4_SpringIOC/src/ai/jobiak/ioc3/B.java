package ai.jobiak.ioc3;

public class B {
public void printingDesign()
{
A a=new A();			//1.they cause maintenance nightmare
								//2.Testing- (Mock testing)
								//Against Agile methodology
								//Decouples the dependencies 
a.print();
}
}
