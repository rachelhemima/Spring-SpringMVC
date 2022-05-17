package ai.jobiak.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseGarden {

	public static void main(String[] args) {
		/*
		 * Garden garden=new Garden() 
		 * garden.setFruits(new Arraylist())
		 *  in oops 
		 */
		//Bean factory
		//ApplicationContext
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(context.containsBean("garden"));
		Garden ref= (Garden) context.getBean("garden");
		System.out.println(ref);
	}
}
