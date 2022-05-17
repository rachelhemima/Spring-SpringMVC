package ai.jobiak.interfaceapps;

public class TestAnimal{
	public static void main(String[] args) {
		//Objection creation & calling interfaces
	//	TestAnimal t1=new TestAnimal();
//interface ----------Class	
	Animal t1=new Cat();
	t1.Eating();
	t1.Barking();
	System.out.println("------");
	Animal t2=new Lion();
	t2.Eating();
	t2.Barking();


	}

}
