package ai.jobiak.interfaceapps;

public class TestInterfaces {

	public static void main(String[] args) {
		I1 ob1=new C();
		ob1.m1();
	I2 ob2=new C();
	ob2.m1();
	ob2.m2();
    ob1.m1();
	I3 ob3=new C();
	ob3.m1();
	ob3.m2();
	ob3.m3();
	ob2.m2();
	ob1.m1();
	}

}
