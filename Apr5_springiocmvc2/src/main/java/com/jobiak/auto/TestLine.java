package com.jobiak.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLine {

	public static void main(String[] args) {
		ApplicationContext context=new	ClassPathXmlApplicationContext("beans.xml");
		Line line=(Line)context.getBean("line");
		line.draw();
	}
}
