package ai.jobiak.ioc1;

public class EmployeeDetails {
private int empid;
private String empname;
private double empsal;

public String toString() {
	return "EmployeeDetails [empid=" + empid + ", empname=" + empname + ", empsal=" + empsal + "]";
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public void setEmpsal(double empsal) {
	this.empsal = empsal;
}

}
