package ai.jobiak.ioc1;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(context.containsBean("employee"));
		Employee ref= (Employee) context.getBean("employee"); 
	//System.out.println(ref);

	}

}
