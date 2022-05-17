package ai.jobiak.override;

public class TestOverride {

	public static void main(String[] args) {
	RbiBank ob1=new RbiBank();
	ob1.rateOfInterest();
	
	Sbi ob2=new Sbi();
	ob2.rateOfInterest();
	
	RbiBank ob3=new Sbi();
//	ob3.rateOfInterest();
   ob3.rateOfInterest();
	
	

	}

}
