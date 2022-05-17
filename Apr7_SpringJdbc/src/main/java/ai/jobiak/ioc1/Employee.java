package ai.jobiak.ioc1;

import java.util.*;

public class Employee 
{
	ArrayList<Employee>emplist; //user defined dependency
	
	public ArrayList<Employee> getEmplist() {
		return emplist;
	}

	public void setEmplist(ArrayList<Employee> emplist) 
	{
		this.emplist = emplist;
	}

}
