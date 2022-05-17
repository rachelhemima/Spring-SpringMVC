package ai.jobiak.usesource;

import org.springframework.core.io.FileSystemResource;

import ai.jobiak.ifaces.BDigital;
import ai.jobiak.source.A;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class TestAB {

	public static void main(String[] args) {

		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("beans.xml"));
		B b=(B)factory.getBean("b");
	
		/*
		 * using classs
		 * b.doPublishing();//throws null pointer exception
		 * if(factory.containsBean("aObj")) {
		 * System.out.println("using Contains Bean()"); A a=(A)factory.getBean("aObj");
		 * a.print(); }
		 */
		//using interfaces
BDigital bDigital=(BDigital)factory.getBean("bDigital");
bDigital.publish();


	}
}
